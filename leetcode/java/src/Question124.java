import struct.TreeNode;
import util.TreeNodeUtils;

/**
 * Question103
 */
public class Question124 {

    public static void main(String[] args) {
        Question124 q = new Question124();
        TreeNode root = TreeNodeUtils.creatConventionalTreeNode(-10, 9, 20, null, null, 15, 7);
        long start = System.currentTimeMillis();
        System.out.println(q.maxPathSum(root));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxGain(root, max);
        return max[0];
    }

    private int maxGain(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(node.left, max), 0);
        int rightGain = Math.max(maxGain(node.right, max), 0);

        max[0] = Math.max(max[0], node.val + leftGain + rightGain);

        return node.val + Math.max(leftGain, rightGain);
    }
}

