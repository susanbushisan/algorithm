package offer;

import struct.ListNode;
import util.ListNodeUtils;

/**
 * <a href="https://leetcode.cn/problems/ti-huan-kong-ge-lcof/">剑指 Offer 05. 替换空格</a>
 */
public class Offer25 {
    public static void main(String[] args) {
        Offer25 o = new Offer25();
        System.out.println(o.mergeTwoLists(ListNodeUtils.creatListNode(1,2,4),ListNodeUtils.creatListNode(1,3,4)));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode d = new ListNode();
        ListNode t = d;
        while (l1 != null || l2 != null){
            if (l1 == null){
                t.next = l2;
                return d.next;
            } else if (l2 == null) {
                t.next = l1;
                return d.next;
            }else {
                if (l1.val < l2.val){
                    t.next = l1;
                    t = t.next;
                    l1 = l1.next;
                }else {
                    t.next = l2;
                    t = t.next;
                    l2 = l2.next;
                }
            }
        }
        return d.next;
    }
}
