package demo;

import struct.DoubleListNode;
import util.ListNodeUtils;

import java.util.*;

public class HashLRU {


    public static final int DEFAULT_MAX_SIZE = 15;

    int maxSiz = DEFAULT_MAX_SIZE;

    int size = 0;

    HashMap<Integer, DoubleListNode> map = new HashMap<>();

    public HashLRU() {
    }

    public HashLRU(int maxSiz) {
        this.maxSiz = maxSiz;
    }

    DoubleListNode head;
    DoubleListNode tail;

    public void getData(int data) {

        //分两种情况，第一种是原先就存在
        if (map.containsKey(data)) {
            DoubleListNode node = map.get(data);
            //分4种情况讨论
            //1.如果是头，那么不用操作
            if (head == node) {
                ListNodeUtils.printListNode(head);
                return;
            }

            //2.如果是尾
            if (tail == node) {
                DoubleListNode pre = tail.pre;
                pre.next = null;
                tail.pre = null;
                tail.next = head;
                head.pre = tail;
                head = tail;
                tail = pre;

                ListNodeUtils.printListNode(head);
                return;
            }

            //3.如果都不是
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = head;
            head.pre = node;
            node.pre = null;
            head = node;

            ListNodeUtils.printListNode(head);
            return;
        }
        //原先不存在,分两种情况，原先是空链和不是空链
        DoubleListNode temp = new DoubleListNode(data);
        map.put(data, temp);
        size++;
        if (tail == null) {
            head = temp;
            tail = temp;
        } else {
            head.pre = temp;
            temp.next = head;
            head = temp;
        }
        if (size == maxSiz + 1) {
            map.remove(tail.val);
            DoubleListNode pre = tail.pre;
            tail.pre = null;
            pre.next = null;
            tail = pre;
            size--;

        }

        ListNodeUtils.printListNode(head);
    }

    public static void main(String[] args) {
        HashLRU lru = new HashLRU(15);
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int randomInt = random.nextInt(30);

            System.out.println("random int : " + randomInt);
            lru.getData(randomInt);
        }

    }
}
