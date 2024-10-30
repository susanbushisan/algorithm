package offer;

import struct.TreeNode;

public class Offer7 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length, 0, inorder.length);

    }

    private TreeNode helper(int[] preorder, int[] inorder, int pLeft, int pRight, int iLeft, int iRight) {
        if (pLeft >= pRight) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pLeft]);
        int j = 0;
        for (int i = iLeft; i < iRight; i++, j++) {
            if (inorder[i] == preorder[pLeft]) {
                break;
            }
        }
        node.left = helper(preorder, inorder, pLeft + 1, pLeft + j+1, iLeft, iLeft + j);
        node.right = helper(preorder, inorder, pLeft + j + 1, pRight, iLeft + j + 1, iRight);

        return node;
    }
}
