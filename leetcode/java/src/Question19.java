import struct.ListNode;
import util.ListNodeUtils;

public class Question19 {
    public static void main(String[] args) {
        Question19 q = new Question19();
        ListNode listNode = ListNodeUtils.creatListNode(1, 2, 3, 4, 5);
        long start = System.currentTimeMillis();
        System.out.println(q.removeNthFromEnd(listNode,2));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode d = new ListNode();
        d.next = head;
        ListNode t = d,slow = d;
        int count = 0;
        while (t != null){
            if (count>n){
                slow  = slow.next;
            }
            t = t.next;
            count ++;
        }
        slow.next = slow.next.next;
        return d.next;
    }
}
