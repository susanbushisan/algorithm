import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

final public class TreeNodeUtils {
    /**
     * 构造一个二叉树
     */
    public static TreeNode creatConventionalTreeNode(Integer... x) {
        if (x.length == 0 || x[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(x[0]);
        int elCount = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (elCount != x.length) {
                    Integer x1 = x[elCount++];
                    if (x1 != null) {
                        poll.left = new TreeNode(x1);
                        queue.offer(poll.left);
                    }
                }
                if (elCount != x.length) {
                    Integer x1 = x[elCount++];
                    if (x1 != null) {
                        poll.right = new TreeNode(x1);
                        queue.offer(poll.right);
                    }
                }
            }

        }
        return root;
    }

    /**
     * 先序遍历
     */
    public static void printPreorder(TreeNode root) {
        printPreorder(root, ",");
    }

    /**
     * 先序遍历
     */
    public static void printPreorder(TreeNode root, String delimiter) {
        List<Integer> ans = new ArrayList<>();
        pre(ans, root);
        print(delimiter, ans);

    }

    /**
     * 中序遍历
     */
    public static void printInorder(TreeNode root) {
        printInorder(root, ",");
    }

    /**
     * 中序遍历
     */
    public static void printInorder(TreeNode root, String delimiter) {
        List<Integer> ans = new ArrayList<>();
        in(ans, root);
        print(delimiter, ans);
    }

    /**
     * 后序遍历
     */
    public static void printPostorder(TreeNode root) {
        printPostorder(root, ",");
    }

    /**
     * 后序遍历
     */
    public static void printPostorder(TreeNode root, String delimiter) {
        List<Integer> ans = new ArrayList<>();
        post(ans, root);
        print(delimiter, ans);
    }


    private static void print(String delimiter, List<Integer> ans) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            if (i != 0) {
                sb.append(delimiter);
            }
            sb.append(ans.get(i));
        }
        System.out.println(sb);
    }


    private static void pre(List<Integer> ans, TreeNode node) {
        if (node == null) {
            return;
        }
        ans.add(node.val);
        pre(ans, node.left);
        pre(ans, node.right);
    }

    private static void in(List<Integer> ans, TreeNode node) {
        if (node == null) {
            return;
        }
        in(ans, node.left);
        ans.add(node.val);
        in(ans, node.right);
    }

    private static void post(List<Integer> ans, TreeNode node) {
        if (node == null) {
            return;
        }
        post(ans, node.left);
        post(ans, node.right);
        ans.add(node.val);
    }

    public static void printAsTree(TreeNode root) {
        List<TreeLine> lines = new ArrayList<>();
        as(lines, root, 0);

        for (TreeLine line : lines) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.tab; i++) {
                if (i != line.tab -1 ){
                    sb.append('\t');
                }else {
                    sb.append("└───");
                }

            }
            sb.append(line.val);
            System.out.println(sb);
        }
    }

    private static void as(List<TreeLine> ans, TreeNode node, int floor) {
        if (node == null) {
            return;
        }
        ans.add(new TreeLine(floor, node.val));
        as(ans, node.left, floor + 1);
        as(ans, node.right, floor + 1);
    }

    static class TreeLine {
        int tab;
        int val;

        public TreeLine(int tab, int val) {
            this.tab = tab;
            this.val = val;
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode = creatConventionalTreeNode(3,9,20,2,3,15,7,4);
        printPreorder(treeNode);
        printInorder(treeNode);
        printPostorder(treeNode);
        printAsTree(treeNode);
    }

}
