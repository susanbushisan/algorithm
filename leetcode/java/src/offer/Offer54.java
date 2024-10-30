package offer;

import struct.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer54 {

    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.left;
        }
        return -1;
    }
}
