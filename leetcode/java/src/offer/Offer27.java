package offer;

import struct.TreeNode;

public class Offer27 {


    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        mirrorTree(root.left);
        mirrorTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }


}
