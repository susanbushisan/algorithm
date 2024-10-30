import struct.TreeNode;
import util.TreeNodeUtils;

public class Question543 {
    public static void main(String[] args) {
        Question543 q = new Question543();
        TreeNode root = TreeNodeUtils.creatConventionalTreeNode(1, 2, 3, 4, 5);
        long start = System.currentTimeMillis();
        System.out.println(q.diameterOfBinaryTree(root));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] helper = helper(root);
        return helper[1];
    }

    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int i = Math.max(left[0], right[0]) + (node.left == null && node.right == null ? 0 : 1);
        int j = (node.left == null ? 0 : left[0] + 1) + (node.right == null ? 0 : right[0] + 1);
        return new int[]{i, Math.max(j, Math.max(left[1], right[1]))};
    }
}
