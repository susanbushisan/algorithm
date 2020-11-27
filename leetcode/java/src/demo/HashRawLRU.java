package demo;

import struct.NextDoubleListNode;
import util.ListNodeUtils;

import java.util.Random;

public class HashRawLRU {


    public static final int DEFAULT_MAX_SIZE = 15;

    int maxSiz = DEFAULT_MAX_SIZE;

    int size = 0;

    NextDoubleListNode[] arr;

    public HashRawLRU() {
        arr = new NextDoubleListNode[maxSiz];
    }

    public HashRawLRU(int maxSiz) {
        this.maxSiz = maxSiz;
        arr = new NextDoubleListNode[maxSiz];
    }

    NextDoubleListNode head;
    NextDoubleListNode tail;

    public void getData(int data) {
        //分两种情况，第一种是原先就存在
        NextDoubleListNode node = arr[hash2Index(data)];
        if (node != null){
            while (node != null && node.val != data){
                node = node.hnext;
            }
            if (node != null){
                if (head == node) {
                    ListNodeUtils.printListNode(head);
                    return;
                }

                //2.如果是尾
                if (tail == node) {
                    NextDoubleListNode pre = tail.pre;
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
        }

        //原先不存在,分两种情况，原先是空链和不是空链
        NextDoubleListNode temp = new NextDoubleListNode(data);
        NextDoubleListNode nextDoubleListNode = arr[hash2Index(data)];
        if (nextDoubleListNode == null){
            arr[hash2Index(data)] = temp;
        }else {
            while (nextDoubleListNode.hnext != null){
                nextDoubleListNode = nextDoubleListNode.hnext;
            }
            nextDoubleListNode.hnext = temp;
        }

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
            NextDoubleListNode listNode = arr[hash2Index(tail.val)];
            //分3种情况，头，尾，中间
            if (listNode == tail){
                arr[hash2Index(tail.val)] = listNode.hnext;
                listNode.hnext = null;
            }else {
                NextDoubleListNode before = listNode;
                listNode = listNode.hnext;
                while (listNode != tail){
                    before = listNode;
                    listNode =  listNode.hnext;
                }
                before.hnext = listNode.hnext;
                listNode.hnext = null;
            }
            NextDoubleListNode pre = tail.pre;
            tail.pre = null;
            pre.next = null;
            tail = pre;
            size--;

        }

        ListNodeUtils.printListNode(head);
    }

    private int hash2Index(int hash){
        return (hash^ (hash >>> 16)) & (maxSiz - 1);
    }

    public static void main(String[] args) {
        HashRawLRU lru = new HashRawLRU(15);
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int randomInt = random.nextInt(30);

            System.out.println("random int : " + randomInt);
            lru.getData(randomInt);
        }

    }
}
