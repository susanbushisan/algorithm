import struct.ListNode;
import util.ListNodeUtils;

public class Question206 {
    public static void main(String[] args) {
        Question206 q = new Question206();
        ListNode listNode = ListNodeUtils.creatListNode(1,2,3,4,5);
        long start = System.currentTimeMillis();
        System.out.println(q.reverseListRecursion(listNode));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public ListNode reverseList(ListNode head) {
        ListNode d = null;
        while (head!=null){
            ListNode temp = head;
            head = head.next;
            temp.next = d;
            d = temp;
        }
        return d;
    }

    public ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


}
