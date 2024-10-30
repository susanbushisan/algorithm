import struct.TreeNode;
import util.TreeNodeUtils;

/**
 * 判断两个二叉树是否相同
 */
public class Question101 {
    public static void main(String[] args) {
        Question101 q = new Question101();
        TreeNode root = TreeNodeUtils.creatConventionalTreeNode(1, 2, 2, null, 3, null, 3);

        long start = System.currentTimeMillis();
        System.out.println(q.isSymmetric(root));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public boolean isSymmetric(TreeNode root) {
        return isSymmetry(root.left, root.right);
    }

    private boolean isSymmetry(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSymmetry(p.left, q.right) && isSymmetry(p.right, q.left);
    }
}
