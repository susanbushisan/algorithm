import com.sun.jmx.remote.internal.ArrayQueue;
import struct.TreeNode;
import util.TreeNodeUtils;

import java.util.*;

public class Question129 {
    public static void main(String[] args) throws Exception {
        Question129 q = new Question129();
        TreeNode root = TreeNodeUtils.creatConventionalTreeNode(0, 1);
        long start = System.currentTimeMillis();
        System.out.println(q.sumNumbers2(root));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 递归法
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbersRecursion(root, 0);
    }

    private int sumNumbersRecursion(TreeNode root, int total) {
        int val = total + root.val;
        if (isLeaf(root)) {
            return val;
        }
        int res = 0;
        if (root.left != null) {
            res += sumNumbersRecursion(root.left, val * 10);
        }
        if (root.right != null) {
            res += sumNumbersRecursion(root.right, val * 10);
        }
        return res;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    /**
     * 广度优先遍历
     */
    public int sumNumbers2(TreeNode root) {
        int res = 0;
        Queue<TreeNode> codeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        codeQueue.add(root);
        numQueue.add(root.val);
        while (!codeQueue.isEmpty()){
            for (int i = 0; i < codeQueue.size(); i++) {
                TreeNode node = codeQueue.poll();
                int num = numQueue.poll();
                if (isLeaf(node)){
                    res += num;
                }
                if (node.left != null) {
                    codeQueue.add(node.left);
                    numQueue.add(num * 10 + node.left.val);
                }
                if (node.right != null) {
                    codeQueue.add(node.right);
                    numQueue.add(num * 10 + node.right.val);
                }
            }
        }
        return res;
    }


}
