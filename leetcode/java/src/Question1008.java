
import java.util.Arrays;
import java.util.Stack;

/**
 * 第一反应，二叉树我不会，第二反应看资料。最后的结果就是讲别人代码的功能粘贴起来
 */
public class Question1008 {
    public static void main(String[] args) {
        int[] preorder = new int[] { 8, 5, 1, 7, 10, 12 };

        Question1008 q = new Question1008();
        long start = System.currentTimeMillis();
        TreeNode treeNode = q.bstFromPreorder(preorder);
        System.out.println(System.currentTimeMillis() - start + "ms");

        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.println(treeNode.val);
                treeNode = treeNode.right;
            }
        }

    }

    public TreeNode buildTree(int[] pre, int[] ord) {
        if (pre.length == 0 || ord.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0; i < ord.length; i++) {
            if (ord[i] == pre[0]) {
                treeNode.left = buildTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(ord, 0, i));
                treeNode.right = buildTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(ord, i + 1, ord.length));
            }
        }
        return treeNode;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] order = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(order);
        return buildTree(preorder, order);
    }
}
