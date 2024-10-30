package offer;

import struct.ListNode;
import util.ListNodeUtils;

/**
 * <a href="https://leetcode.cn/problems/ti-huan-kong-ge-lcof/">剑指 Offer 05. 替换空格</a>
 */
public class Offer24 {
    public static void main(String[] args) {
        Offer24 o = new Offer24();
        System.out.println(o.reverseList(ListNodeUtils.creatListNode(1,2,3,4,5)));
    }

    public ListNode reverseList(ListNode head) {
        ListNode d = new ListNode();
        while (head != null){
            ListNode temp = head.next;
            head.next = d.next;
            d.next = head;
            head = temp;
        }
        return d.next;
    }
}
