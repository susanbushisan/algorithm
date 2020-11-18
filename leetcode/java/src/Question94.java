import struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Question94 {


    public static void main(String[] args) {
        Question94 q = new Question94();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        long start = System.currentTimeMillis();
        System.out.println(q.inorderTraversal(root));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }

        return ans;
    }

    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    private void helper(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        helper(node.left, ans);
        ans.add(node.val);
        helper(node.right, ans);
    }
}
