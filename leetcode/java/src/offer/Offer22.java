package offer;

import struct.ListNode;
import util.ListNodeUtils;

/**
 * <a href="https://leetcode.cn/problems/ti-huan-kong-ge-lcof/">剑指 Offer 05. 替换空格</a>
 */
public class Offer22 {
    public static void main(String[] args) {
        Offer22 o = new Offer22();
        System.out.println(o.getKthFromEnd(ListNodeUtils.creatListNode(1,2,3,4,5), 2));
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            end = end.next;
        }
        while (end != null){
            head = head.next;
            end = end.next;
        }
        return head;

    }
}
