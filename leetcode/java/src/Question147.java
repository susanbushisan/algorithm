

public class Question147 {
    public static void main(String[] args) {
        Question147 q = new Question147();
        ListNode head = ListNodeUtils.creatListNode(4,2,1,3);

        long start = System.currentTimeMillis();
        System.out.println(q.insertionSortList(head));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null||head.next==null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode breakPoint = slow.next;
        slow.next = null;
        ListNode left = insertionSortList(head);
        ListNode right = insertionSortList(breakPoint);
        return sort(left,right);
    }

    private ListNode sort(ListNode left,ListNode right){
        if (left == null){
            return right;
        }else if (right == null){
            return left;
        }
        if (left.val < right.val){
            left.next = sort(left.next,right);
            return left;
        }else {
            right.next = sort(right.next,left);
            return right;
        }
    }
}
