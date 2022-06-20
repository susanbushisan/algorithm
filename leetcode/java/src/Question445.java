import struct.ListNode;
import util.ListNodeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question445 {
    public static void main(String[] args) {
        Question445 q = new Question445();
        ListNode l1 = ListNodeUtils.creatListNode(7, 2, 4, 3);
        ListNode l2 = ListNodeUtils.creatListNode(5, 6, 4);
        long start = System.currentTimeMillis();
        System.out.println(q.addTwoNumbers(l1, l2));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> s1 = new ArrayDeque<>();
        Deque<ListNode> s2 = new ArrayDeque<>();
        while (l1 != null){
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2);
            l2 = l2.next;
        }
        ListNode res = null;
        boolean flag = false;
        while (!s1.isEmpty() || !s2.isEmpty() || flag){
            int i = 0;
            if (!s1.isEmpty()){
                i += s1.pop().val;
            }
            if (!s2.isEmpty()){
                i += s2.pop().val;
            }
            if (flag){
                i ++;
            }
            if (i >= 10){
                i -= 10;
                flag = true;
            }else {
                flag = false;
            }
            ListNode temp = res;
            res = new ListNode(i);
            res.next = temp;
        }
        return res;
    }
}
