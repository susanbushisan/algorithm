package demo;

import struct.DoubleListNode;
import struct.ListNode;
import util.ListNodeUtils;

import java.util.Random;

/**
 * LRU 算法是经典的缓存淘汰算法，淘汰最近最少使用的数据，本demo使用单链表实现
 */
public class LinkedLRU {

    public static final int DEFAULT_MAX_SIZE = 15;

    int maxSiz = DEFAULT_MAX_SIZE;

    int size = 0;

    public void setSize(int size) {
        this.size = size;
    }

    ListNode head = null;

    public void getData(int data) {
        ListNode temp = head;
        ListNode pre = null;
        while (temp != null) {
            if (temp.val == data) {
                if (pre != null) {
                    pre.next = temp.next;
                    temp.next = head;
                    head = temp;
                }
                ListNodeUtils.printListNode(head);
                return;
            }
            pre = temp;
            temp = temp.next;
        }
        temp = new ListNode(data);
        temp.next = head;
        head = temp;
        if (++size == maxSiz + 1) {
            temp = head.next;
            ListNode slow = head;
            while (temp.next != null) {
                slow = temp;
                temp = temp.next;
            }
            slow.next = null;
            size--;
        }
        ListNodeUtils.printListNode(head);
    }

    public static void main(String[] args) {
        LinkedLRU lru = new LinkedLRU();
        lru.setSize(20);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int randomInt = random.nextInt(30);

            System.out.println("random int : " + randomInt);
            lru.getData(randomInt);
        }

    }
}
