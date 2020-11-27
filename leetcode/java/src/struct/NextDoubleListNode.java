package struct;

import java.util.Objects;

public class NextDoubleListNode extends DoubleListNode {

    public NextDoubleListNode pre;
    public NextDoubleListNode next;
    public NextDoubleListNode hnext;

    public NextDoubleListNode() {
    }

    public NextDoubleListNode(int x) {
        super(x);
    }

    public NextDoubleListNode getPre() {
        return pre;
    }

    @Override
    public NextDoubleListNode getNext() {
        return next;
    }

    public NextDoubleListNode getHnext() {
        return hnext;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NextDoubleListNode that = (NextDoubleListNode) o;
        return Objects.equals(val, that.val);
    }

    @Override
    public int hashCode() {
        return super.val;
    }
}
