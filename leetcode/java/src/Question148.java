import struct.ListNode;
import util.ListNodeUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question148 {
    public static void main(String[] args) {
        Question148 q = new Question148();
        ListNode head = ListNodeUtils.creatListNode(-1, 5, 3, 4, 0);

        long start = System.currentTimeMillis();
        System.out.println(q.sortList(head));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public ListNode sortList(ListNode head) {
        ListNode d = new ListNode(Integer.MIN_VALUE);

        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        while (head != null) {
            heap.add(head);
            head = head.next;
        }
        ListNode t = d;
        while (!heap.isEmpty()) {
            t.next = heap.poll();
            t.next.next = null;
            t = t.next;
        }

        return d.next;
    }

}
