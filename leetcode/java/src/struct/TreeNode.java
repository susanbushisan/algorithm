package struct;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode() {

    }

    @Override
    public String toString() {
        return "val=" + val;
    }
}