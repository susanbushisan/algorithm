package demo;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LRUCache<K, V> {

    private Node<K, V> head;
    private Node<K, V> tail;
    private int maxSize;
    private Node<K, V>[] o;

    private int size = 0;

    static class Node<K, V> {
        Node<K, V> pre;
        Node<K, V> next;
        Node<K, V> hnext;
        K k;
        V v;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    @SuppressWarnings("unchecked")
    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
        this.o = (Node<K, V>[]) Array.newInstance(Node.class, maxSize);
    }

    public V get(K key) {
        Node<K, V> node = o[hash2Index(key)];
        while (node != null && !key.equals(node.k)) {
            node = node.hnext;
        }
        if (node != null) {
            //缓存中存在数据，只要移动链表位置即可
            if (node == tail) {
                head.pre = tail;
                tail.next = head;
                tail.pre.next = null;
                tail = tail.pre;
                head = head.pre;
                head.pre = null;
            } else if (node != head) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.pre = null;
                node.next = head;
                head.pre = node;
                head = node;
            }
            return head.v;
        }

        return null;
    }

    public void put(K key, V value) {
        //查原有是否有
        Node<K, V> node = o[hash2Index(key)];

        if (node != null) {
            while (node != null && !key.equals(node.k)) {
                node = node.hnext;
            }
            if (node != null) {
                if (node == tail) {
                    head.pre = tail;
                    tail.next = head;
                    tail.pre.next = null;
                    tail = tail.pre;
                    head = head.pre;
                    head.pre = null;
                } else if (node != head) {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                    node.pre = null;
                    node.next = head;
                    head.pre = node;
                    head = node;
                }
                head.v = value;
                return;
            }

        }

        //缓存中不存在
        Node<K, V> temp = new Node<>(key, value);
        if (head ==null){
            head = temp;
            tail = temp;
        }else {
            //头插法
            head.pre = temp;
            temp.next = head;
            head = temp;
        }

        Node<K, V> n = o[hash2Index(key)];
        if (n == null){
            o[hash2Index(key)] = temp;
        }else {
            while (n.hnext != null){
                n = n.hnext;
            }
            n.hnext = temp;
        }
        size++;


        //如果大小超过指定，淘汰链尾元素
        if (size == maxSize + 1) {
            Node<K, V> t = o[hash2Index(tail.k)];
            if (t != tail){
                Node<K, V> before = t;
                t = t.hnext;
                while (t != tail){
                    before = t;
                    t = t.hnext;
                }
                before.hnext = tail.hnext;
                tail.hnext = null;
            }else {
                o[hash2Index(tail.k)] = tail.hnext;
                tail.hnext = null;
            }
            tail = tail.pre;
            tail.next.pre = null;
            tail.next = null;
            size --;

        }

    }


    private int hash2Index(K key) {
        int hash = key.hashCode();
        return (hash ^ (hash >>> 16)) & (maxSize - 1);
    }

    /**
     * 打印链表
     *
     */
    public String toString() {
        if (head == null) {
            return "";
        }
        StringBuilder r = new StringBuilder();
        Node temp = head;
        Set<Node> contain = new HashSet<>();
        while (temp != null) {
            if (contain.contains(temp)) {
                r.append("->").append(" link after ").append(temp.k);
                break;
            }
            contain.add(temp);
            if (temp != head) {
                r.append("->");
            }
            r.append(temp.k);
            temp = temp.next;
        }
        return r.toString();
    }

    public static void main(String[] args) {
        LRUCache<Integer,Integer> lru = new LRUCache<>(15);
        Random random = new Random(3);

        for (int i = 0; i < 100; i++) {
            int randomInt = random.nextInt(30);

            System.out.println("random int : " + randomInt);
            lru.put(randomInt,randomInt);
            System.out.println(lru);
        }
        lru.get(0);
        System.out.println(lru);
    }

}
