

import struct.ListNode;
import util.ListNodeUtils;

import java.util.HashSet;
import java.util.Set;

public class Question142 {
    public static void main(String[] args) {
        Question142 q = new Question142();
        ListNode head = ListNodeUtils.creatListNode(4,2,1,3);
        int pos = 2;
        ListNodeUtils.circleListNode(head,pos);
        System.out.println("original:");
        ListNodeUtils.printListNode(head);
        System.out.println();
        long start = System.currentTimeMillis();
        ListNodeUtils.printCircleListNode(q.detectCycle(head));
        ListNodeUtils.printCircleListNode(q.detectCycleTerrible(head));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 快慢指针，可以通过数据证明
     */
    public ListNode detectCycleI(ListNode head) {
        ListNode fast = head,slow = head;
        try {
            do{
                fast = fast.next.next;
                slow = slow.next;
            }
            while (fast != slow);
        } catch (Exception e) {
            return null;
        }
        while (head != slow){
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

    /**
     * 通过Set，找到重复的节点为答案
     */
    public ListNode detectCycleTerrible(ListNode head) {
        Set<ListNode> context = new HashSet<ListNode>();
        ListNode temp = head;
        while(temp != null){
            if(context.contains(temp)){
                return temp;
            }
            context.add(temp);
            temp = temp.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head,fast = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        slow = head;
        while (true){
            if (slow == fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next;

        }
    }

}
