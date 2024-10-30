import struct.TreeNode;
import util.TreeNodeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Question98 {


    public static void main(String[] args) {
        Question98 q = new Question98();

        TreeNode root = TreeNodeUtils.creatConventionalTreeNode(5, 1, 4, null, null, 3, 6);

        long start = System.currentTimeMillis();
        System.out.println(q.isValidBST(root));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public boolean isValidBSTI(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValidBST(TreeNode root, long upperBound, long lowerBound) {
        if (root == null) {
            return true;
        }
        if (root.val <= lowerBound || root.val >= upperBound) {
            return false;
        }
        return isValidBST(root.left, root.val, lowerBound) && isValidBST(root.right, upperBound, root.val);
    }

    //方法二：中序遍历
    long min = Long.MIN_VALUE;

    public boolean isValidBSTP(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean flag = isValidBSTP(root.left);
        if (flag) {
            if (root.val <= min) {
                return false;
            } else {
                min = root.val;
            }
        } else {
            return false;
        }
        return isValidBSTP(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= min) {
                return false;
            } else {
                min = root.val;
            }
            root = root.right;
        }

        return true;
    }


}
