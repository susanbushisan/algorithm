import struct.ListNode;
import util.ListNodeUtils;

public class Question147 {
    public static void main(String[] args) {
        Question147 q = new Question147();
        ListNode head = ListNodeUtils.creatListNode(-1, 5, 3, 4, 0);

        long start = System.currentTimeMillis();
        System.out.println(q.insertionSortList(head));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public ListNode insertionSortListI(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode breakPoint = slow.next;
        slow.next = null;
        ListNode left = insertionSortListI(head);
        ListNode right = insertionSortListI(breakPoint);
        return sort(left, right);
    }

    private ListNode sort(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        if (left.val < right.val) {
            left.next = sort(left.next, right);
            return left;
        } else {
            right.next = sort(right.next, left);
            return right;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode h = insertionSortList(head.next);
        ListNode c1 = h;
        if (h == null || h.val > head.val) {
            head.next = h;
            return head;
        }
        while (c1.next != null && c1.next.val < head.val) {
            c1 = c1.next;
        }
        head.next = c1.next;
        c1.next = head;
        return h;
    }

}
