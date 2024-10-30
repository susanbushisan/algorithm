import struct.ListNode;
import util.ListNodeUtils;

public class Question234 {
    public static void main(String[] args) {
        Question234 q = new Question234();
        ListNode head = ListNodeUtils.creatListNode(1, 2, 2, 1);
        long start = System.currentTimeMillis();
        System.out.println(q.isPalindrome(head));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null){
            return true;
        }
        ListNode slow = head, fast = head, temp, pre = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        ListNode l1, l2;
        if (fast.next == null) {
            l1 = pre;
            l2 = slow.next;
            //pre 和 slow.next 相等
        } else {
            if (slow.next.val != slow.val) {
                return false;
            }
            l1 = pre;
            l2 = slow.next.next;
            // slow.next == slow 和 pre 和slow.next.next 相等
        }

        while (l1 != null && l2 != null) {

            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
