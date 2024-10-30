import struct.ListNode;
import util.ListNodeUtils;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Question160 {
    public static void main(String[] args) {
        Question160 q = new Question160();
        ListNode listA = ListNodeUtils.creatListNode(4, 1, 8, 4, 5);
        ListNode listB = new ListNode(2);
        listB.next = new ListNode(7);
        listB.next.next = listA.next.next.next;

        long start = System.currentTimeMillis();
        System.out.println(q.getIntersectionNode(listA, listB).val);
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


}
