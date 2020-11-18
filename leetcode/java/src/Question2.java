import struct.ListNode;
import util.ListNodeUtils;

/**
 * 求两数之和
 */
public class Question2 {
    public static void main(String[] args) {
        Question2 q = new Question2();
        ListNode l1 = ListNodeUtils.creatListNode(2, 4, 3);
        ListNode l2 = ListNodeUtils.creatListNode(1, 9, 9, 9, 9, 9, 9, 9, 9, 9);
        long start = System.currentTimeMillis();
        System.out.println(q.addTwoNumbers2(l1, l2));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 效率比较不错，和官方解答是同一种方法，缺点是代码比较长
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean step = false;
        int i = l1.val + l2.val;
        if (i >= 10) {
            step = true;
            i -= 10;
        }
        ListNode result = new ListNode(i);
        ListNode t1 = l1.next, t2 = l2.next, tNode = result;
        int i1 = 0, i2 = 0, temp = 0;

        while (t1 != null || t2 != null || step) {
            if (t1 != null) {
                i1 = t1.val;
                t1 = t1.next;
            } else {
                i1 = 0;
            }
            if (t2 != null) {
                i2 = t2.val;
                t2 = t2.next;
            } else {
                i2 = 0;
            }
            temp = i1 + i2;
            if (step) {
                temp++;
            }
            if (temp >= 10) {
                step = true;
                temp -= 10;
            } else {
                step = false;
            }
            tNode.next = new ListNode(temp);
            tNode = tNode.next;
        }

        return result;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        ListNode re = result;
        int carry = (l1.val + l2.val) >= 10 ? 1 : 0;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            int sum = l1.val + l2.val + carry;
            if (sum >= 10) {
                result.next = new ListNode(sum - 10);
                result = result.next;
                carry = 1;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
                carry = 0;
            }
        }
        if (l1.next == null && l2.next == null) {
            if (carry == 1) {
                result.next = new ListNode(1);
            }
            return re;
        } else if (l1.next == null) {
            while (l2.next != null) {
                l2 = l2.next;
                int sum = l2.val + carry;
                if (sum >= 10) {
                    result.next = new ListNode(sum - 10);
                    result = result.next;
                    carry = 1;
                } else {
                    result.next = new ListNode(sum);
                    result = result.next;
                    carry = 0;
                }
            }
            if (carry == 1) {
                result.next = new ListNode(1);
            }
            return re;
        } else {
            while (l1.next != null) {
                l1 = l1.next;
                int sum = l1.val + carry;
                if (sum >= 10) {
                    result.next = new ListNode(sum - 10);
                    result = result.next;
                    carry = 1;
                } else {
                    result.next = new ListNode(sum);
                    result = result.next;
                    carry = 0;
                }
            }
            if (carry == 1) {
                result.next = new ListNode(1);
            }
            return re;
        }

    }
}
