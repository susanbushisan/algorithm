import struct.TreeNode;
import util.TreeNodeUtils;

public class Question110 {

    public static void main(String[] args) {
        Question110 q = new Question110();
        TreeNode treeNode = TreeNodeUtils.creatConventionalTreeNode(1,2,2,3,3,null,null,4,4);
        long start = System.currentTimeMillis();
        System.out.println(q.isBalancedA(treeNode));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node){
        if (node == null){
            return 0;
        }
        return Math.max(height(node.left),height(node.right)) + 1;
    }

    public boolean isBalancedA(TreeNode root) {
        return heightA(root) >= 0;
    }

    public int heightA(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightA(root.left);
        int rightHeight = heightA(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
