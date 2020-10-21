import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Question106 {
    public static void main(String[] args) {
        Question106 q = new Question106();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        long start = System.currentTimeMillis();
        TreeNode treeNode = q.buildTree(inorder, postorder);
        System.out.println(treeNode);
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }




    public TreeNode buildTreeSlow(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        int val = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(val);
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == val) {
                break;
            }
        }

        int[] inorderLeft = Arrays.copyOf(inorder, i);
        int[] postorderLeft = Arrays.copyOf(postorder, i);
        root.left = buildTree(inorderLeft, postorderLeft);
        int[] inorderRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        int[] postorderRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);
        root.right = buildTree(inorderRight, postorderRight);
        return root;
    }

}
