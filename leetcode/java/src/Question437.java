import struct.TreeNode;
import util.TreeNodeUtils;

public class Question437 {
    public static void main(String[] args) {
        Question437 q = new Question437();
        TreeNode root = TreeNodeUtils.creatConventionalTreeNode(1000000000, 1000000000, null, 294967296, null, 1000000000, null, 1000000000, null, 1000000000);
        long start = System.currentTimeMillis();
        System.out.println(q.pathSum(root, 0));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }


    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int i = h1(root, targetSum);
        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + i;
    }

    private int h1(TreeNode node, long targetSum) {
        if (node == null) {
            return 0;
        }
        return h1(node.left, targetSum - node.val) + h1(node.right, targetSum - node.val) + (node.val == targetSum ? 1 : 0);
    }
}
