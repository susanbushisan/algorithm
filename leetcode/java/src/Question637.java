
import java.util.*;

/**
 * 第一时间想到的是广度优先遍历二叉树，每一层级求平均然后添加到list中,其次就是广度优先遍历
 */
public class Question637 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        Question637 q637 = new Question637();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        long start = System.currentTimeMillis();
        System.out.println(q637.averageOfLevels(root));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    static Map<Integer, List<Integer>> process = new TreeMap<>();

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        findChildLevel(root, 0);

        process.forEach((k, v) -> result.add(v.stream().mapToDouble(e->e).average().getAsDouble()));
        return result;
    }

    private void findChildLevel(TreeNode root, int i) {
        if (root != null) {
            if (process.get(i) == null) {
                List<Integer> list = new LinkedList<>();
                list.add(root.val);
                process.put(i, list);
            } else {
                process.get(i).add(root.val);
            }
            findChildLevel(root.left, i + 1);
            findChildLevel(root.right, i + 1);
        }
    }

}
