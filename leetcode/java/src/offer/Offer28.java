package offer;

import struct.TreeNode;

public class Offer28 {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        } else if (n1 == null || n2 == null) {
            return false;
        }
        return n1.val == n2.val && helper(n1.left, n2.right) && helper(n1.right, n2.left);
    }


}
