import struct.TreeNode;
import util.TreeNodeUtils;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Question105 {
    public static void main(String[] args) {
        Question105 q = new Question105();
        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] in = {3, 2, 4, 1, 6, 5, 7};

        long start = System.currentTimeMillis();
        TreeNode treeNode = q.buildTree(pre, in);
        TreeNodeUtils.printInorder(treeNode);
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return reConstructBinaryTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode reConstructBinaryTreeHelper(int[] pre, int preLeft, int preRight, int[] in, int inLeft, int inRight) {
        if (preLeft >= preRight) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preLeft]);
        int i = inLeft;
        for (; i < inRight; i++) {
            if (in[i] == pre[preLeft]) {
                break;
            }
        }
        node.left = reConstructBinaryTreeHelper(pre, preLeft + 1, preLeft + 1 + i - inLeft, in, inLeft, i);
        node.right = reConstructBinaryTreeHelper(pre, preLeft + 1 + i - inLeft, preRight, in, i +1, inRight);
        return node;
    }



}
