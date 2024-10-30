import struct.TreeNode;
import util.TreeNodeUtils;

public class Question538 {
    public static void main(String[] args) {
        Question538 q = new Question538();
        TreeNode root = TreeNodeUtils.creatConventionalTreeNode(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8);
        long start = System.currentTimeMillis();
        System.out.println(q.convertBST(root));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    public TreeNode convertBST(TreeNode root) {
        help(root, 0);
        return root;
    }

    private int help(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        sum = help(node.right, sum);
        node.val += sum;
        sum = help(node.left, node.val);
        return sum;
    }
}
