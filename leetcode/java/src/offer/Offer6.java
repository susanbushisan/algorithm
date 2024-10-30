package offer;

import struct.ListNode;
import util.ListNodeUtils;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Offer6 {

    public static void main(String[] args) {
        Offer6 o = new Offer6();
        System.out.println(Arrays.toString(o.reversePrint(ListNodeUtils.creatListNode(1, 2, 3))));
    }


    public int[] reversePrint(ListNode head) {
        ListNode d = new ListNode();
        int count = 0;
        while (head != null) {
            ListNode temp = head.next;
            head.next = d.next;
            d.next = head;
            head = temp;
            count ++;
        }
        int i = 0;
        int[] res = new int[count];
        d = d.next;
        while (d != null) {
            res[i++] = d.val;
            d = d.next;
        }
        return res;
    }
}
