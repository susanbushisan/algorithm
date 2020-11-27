package struct;

import java.util.HashSet;
import java.util.Set;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }


    @Override
    public String toString() {
        StringBuilder r = new StringBuilder(String.valueOf(getVal()));
        ListNode temp = getNext();
        Set<ListNode> contain = new HashSet<>();
        while (temp != null){
            if (contain.contains(temp)){
                r.append(" -> link after ").append(temp.getVal());
                break;
            }
            contain.add(temp);
            r.append(" -> ").append(temp.getVal());
            temp = temp.getNext();
        }
        return r.toString();
    }
}
