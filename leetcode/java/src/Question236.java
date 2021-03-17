import struct.TreeNode;
import util.TreeNodeUtils;

import java.util.*;

public class Question236 {


    public static void main(String[] args) {
        Question236 q = new Question236();
        long start = System.currentTimeMillis();
        TreeNode treeNode = TreeNodeUtils.creatConventionalTreeNode(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        System.out.println(q.lowestCommonAncestor2(treeNode, treeNode.left, treeNode.right));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean f1 = dfs(root.left, p, q);
        boolean f2 = dfs(root.right, p, q);
        if ((f1 && f2) || ((root == p || root == q) && (f1 || f2))) {
            ans = root;
        }
        return f1 || f2 || root == p || root == q;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> cache = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    cache.put(poll.left,poll);
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    cache.put(poll.right,poll);
                    queue.offer(poll.right);
                }
            }
        }
        Set<TreeNode> pNode = new HashSet<>();
        pNode.add(p);
        while (cache.get(p) != null){
            pNode.add(cache.get(p));
            p = cache.get(p);
        }
        while (q != null){
            if (pNode.contains(q)){
                return q;
            }
            q = cache.get(q);
        }
        return null;
    }

}
