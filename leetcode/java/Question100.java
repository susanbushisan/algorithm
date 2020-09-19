

/**
 * 判断两个二叉树是否相同
 */
public class Question100 {
    public static void main(String[] args) {
        Question100 q = new Question100();
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p2.left = new TreeNode(2);

        long start = System.currentTimeMillis();
        System.out.println(q.isSameTree(p1, p2));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 思路 如果有树为null则可以判断是否相同，如果另一棵树为null则相同否则不同
     * 然后依次判断当前节点数据是否相同，左节点树是否相同，又节点树是否相同
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null){
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
