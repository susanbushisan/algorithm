import struct.TreeNode;
import util.TreeNodeUtils;

import java.util.*;

/**
 * Question103
 */
public class Question104 {

    public static void main(String[] args) {
        Question104 q = new Question104();
        TreeNode root = TreeNodeUtils.creatConventionalTreeNode(3, 9, 20, null, null, 15, 7);
        long start = System.currentTimeMillis();
        System.out.println(q.maxDepth(root));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

