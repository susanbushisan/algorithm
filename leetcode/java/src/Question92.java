import struct.ListNode;

/**
 * 最大连续乘积
 */
public class Question92 {


    public static void main(String[] args) {
        Question92 q = new Question92();
        ListNode root = new ListNode( 5);
        long start = System.currentTimeMillis();
        System.out.println(q.reverseBetween(root, 1, 1));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     *
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode d = new ListNode(0) , mEl = null, mElP = null, nEl = null;
        ListNode temp = d;
        temp.next = head;
        if (m == n){
            return  d.next;
        }
        int index = 0;
        while (true) {
            if (index < m - 1){
                temp = temp.next;
                index ++;
            }else if (index == m - 1) {
                mElP = temp;
                temp = temp.next;
                index ++;
            }else if (index == m){
                mEl = temp;
                nEl = temp;
                temp = temp.next;
                index ++;
            }else if (index < n ){
                ListNode next = temp.next;
                temp.next = mEl;
                mEl = temp;
                temp = next;
                index ++;
            }else {
                ListNode next = temp.next;
                temp.next = mEl;
                mElP.next = temp;
                nEl.next = next;

                break;
            }

        }
        return d.next;
    }


}
