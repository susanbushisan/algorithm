import java.util.Deque;
import java.util.LinkedList;

public class Question143 {
    public static void main(String[] args) {
        Question143 q = new Question143();
        ListNode head = new ListNode(1,2,3,4,5);

        long start = System.currentTimeMillis();
        q.reorderList(head);
        System.out.println(System.currentTimeMillis() - start + "ms");
        System.out.println(head);
    }

    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        Deque<ListNode> deque = new LinkedList<>();
        ListNode var = head.next;
        while (var != null){
            deque.addLast(var);
            var = var.next;
        }


        while (!deque.isEmpty()){
            ListNode listNode = deque.pollLast();
            head.next = listNode;
            head = listNode;
            if (!deque.isEmpty()){
                listNode = deque.pollFirst();
                head.next = listNode;
                head = listNode;
            }
        }
        head.next = null;
    }

}
