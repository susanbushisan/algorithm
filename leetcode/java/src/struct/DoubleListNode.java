package struct;

public class DoubleListNode extends ListNode {
    public DoubleListNode pre;
    public DoubleListNode next;

    public DoubleListNode() {
    }

    public DoubleListNode(int x) {
        super(x);
    }

    public DoubleListNode getPre() {
        return pre;
    }

    @Override
    public DoubleListNode getNext() {
        return next;
    }

}
