package offer;

import struct.ListNode;
import util.ListNodeUtils;

/**
 * <a href="https://leetcode.cn/problems/ti-huan-kong-ge-lcof/">剑指 Offer 05. 替换空格</a>
 */
public class Offer52 {
    public static void main(String[] args) {
        Offer52 o = new Offer52();
//        ListNode l1 = ListNodeUtils.creatListNode(4, 1, 8, 4, 5);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(0);
//        l2.next.next = new ListNode(1);
//        l2.next.next.next = l1.next.next;
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l2.next = l1;
        System.out.println(o.getIntersectionNode(l1, l2));
    }

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }
}
