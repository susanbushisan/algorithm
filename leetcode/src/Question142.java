

import java.util.HashSet;
import java.util.Set;

public class Question142 {
    public static void main(String[] args) {
        Question142 q = new Question142();
        ListNode head = new ListNode(4,2,1,3);
        int pos = -1;
        ListNode temp = head;
        ListNode circle = null;
        int count = 0;
        while (true){
            if (count == pos){
                circle = temp;
            }
            if (temp.next == null){
                temp.next = circle;
                break;
            }
            count++;
            temp = temp.next;
        }

        long start = System.currentTimeMillis();
        System.out.println(q.detectCycle(head).val);
        System.out.println(q.detectCycleTerrible(head).val);
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 快慢指针，可以通过数据证明
     */
    public ListNode detectCycle(ListNode head) {
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


}
