package offer;

import struct.TreeNode;


public class Offer55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return Math.abs(maxDepth(root.left)-maxDepth(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
