import struct.TreeNode;

public class Question112 {


    public static void main(String[] args) {
        Question112 q = new Question112();
//        struct.TreeNode root = new struct.TreeNode(5);
//        root.left = new struct.TreeNode(4);
//        root.left.left = new struct.TreeNode(11);
//        root.left.left.left = new struct.TreeNode(7);
//        root.left.left.right = new struct.TreeNode(2);
//        root.right = new struct.TreeNode(8);
//        root.right.left = new struct.TreeNode(13);
//        root.right.right = new struct.TreeNode(4);
//        root.right.right.right = new struct.TreeNode(1);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-2);
        long start = System.currentTimeMillis();
        System.out.println(q.hasPathSum(root, -1));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
