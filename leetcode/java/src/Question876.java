import struct.ListNode;
import util.ListNodeUtils;

public class Question876 {
    public static void main(String[] args) {
        Question876 q = new Question876();
        ListNode listNode = ListNodeUtils.creatListNode(1,2,3,4,5,6);
        long start = System.currentTimeMillis();
        System.out.println(q.middleNode(listNode));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head,slow = head;
        while (fast !=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
