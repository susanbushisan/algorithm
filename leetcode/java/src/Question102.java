
import struct.TreeNode;

import java.util.*;

/**
 * Question113
 */
public class Question102 {

    public static void main(String[] args) {
        Question102 question = new Question102();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        long start = System.currentTimeMillis();
        System.out.println(question.levelOrder(root));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> current = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                assert poll != null;
                current.add(poll.val);
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
            ans.add(current);
        }
        return ans;
    }
}

