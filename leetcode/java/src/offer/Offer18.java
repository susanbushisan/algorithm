package offer;

import struct.ListNode;
import util.ListNodeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/ti-huan-kong-ge-lcof/">剑指 Offer 05. 替换空格</a>
 */
public class Offer18 {
    public static void main(String[] args) {
        Offer18 o = new Offer18();
        System.out.println(o.deleteNode(ListNodeUtils.creatListNode(4,5,1,9), 5));
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode d = new ListNode();
        d.next = head;
        ListNode pre = d;
        while (head.val != val){
            pre = head;
            head = head.next;
        }
        pre.next = head.next;
        head.next = null;
        return d.next;
    }
}
