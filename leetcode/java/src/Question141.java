

import struct.ListNode;
import util.ListNodeUtils;

import java.util.HashSet;
import java.util.Set;

public class Question141 {
    public static void main(String[] args) {
        Question141 q = new Question141();
        ListNode head = ListNodeUtils.creatListNode(4, 2, 1, 3);
        int pos = 2;
        ListNodeUtils.circleListNode(head, pos);
        System.out.println("original:");
        ListNodeUtils.printListNode(head);
        System.out.println();
        long start = System.currentTimeMillis();
        System.out.println(q.hasCycleDoublePoint(head));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 哈希表
     */
    public boolean hasCycleI(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针，可以通过数据证明
     */
    public boolean hasCycleDoublePoint(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }


}
