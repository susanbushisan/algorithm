

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int... x) {
        val = x[0];
        next = new ListNode(x[1]);
        ListNode listNode = next;
        for (int i = 2; i < x.length; i++) {
            listNode.next = new ListNode(x[i]);
            listNode = listNode.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder(String.valueOf(val));
        ListNode temp = next;
        while (temp != null){
            r.append(" -> ").append(temp.val);
            temp = temp.next;
        }
        return r.toString();
    }
}
