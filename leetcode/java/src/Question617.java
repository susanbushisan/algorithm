import struct.TreeNode;
import util.TreeNodeUtils;

public class Question617 {
    public static void main(String[] args) {
        Question617 q = new Question617();
        TreeNode root1 = TreeNodeUtils.creatConventionalTreeNode(1, 3, 2, 5);
        TreeNode root2 = TreeNodeUtils.creatConventionalTreeNode(2, 1, 3, null, 4, null, 7);
        long start = System.currentTimeMillis();
        TreeNode treeNode = q.mergeTrees(root1, root2);
        System.out.println(System.currentTimeMillis() - start + "ms");
        TreeNodeUtils.printAsTree(treeNode);

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        int val = (root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val);
        TreeNode treeNode = new TreeNode(val);
        treeNode.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        treeNode.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return treeNode;

    }
}
