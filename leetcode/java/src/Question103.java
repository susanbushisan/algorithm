import java.util.*;

/**
 * Question103
 */
public class Question103 {

    public static void main(String[] args) {
        Question103 question = new Question103();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        long start = System.currentTimeMillis();
        System.out.println(question.zigzagLevelOrder(root));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        boolean direction = true;
        while (deque.size() > 0) {
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = direction ? deque.pollLast() : deque.pollFirst();
                temp.add(treeNode.val);
                if (direction) {
                    if (treeNode.left != null) {
                        deque.addFirst(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        deque.addFirst(treeNode.right);
                    }
                } else {
                    if (treeNode.right != null) {
                        deque.addLast(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        deque.addLast(treeNode.left);
                    }
                }
            }
            direction = !direction;
            ans.add(temp);
        }

        return ans;
    }
}

