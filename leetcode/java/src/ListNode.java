import java.util.HashSet;
import java.util.Set;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder(String.valueOf(val));
        ListNode temp = next;
        Set<ListNode> contain = new HashSet<>();
        while (temp != null){
            if (contain.contains(temp)){
                r.append(" -> link after ").append(temp.val);
                break;
            }
            contain.add(temp);
            r.append(" -> ").append(temp.val);
            temp = temp.next;
        }
        return r.toString();
    }
}
