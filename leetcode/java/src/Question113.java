
import struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Question113
 */
public class Question113 {

    public static void main(String[] args) {
        Question113 question = new Question113();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        long start = System.currentTimeMillis();
        System.out.println(question.pathSum3(root, 22));
        System.out.println(System.currentTimeMillis() - start + "ms");
         start = System.currentTimeMillis();
        System.out.println(question.pathSum2(root, 22));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    /**
     * 深度优先搜索
     */
    List<List<Integer>> list = new ArrayList<>();
    ArrayList<Integer> inner = new ArrayList<>();
    public List<List<Integer>> pathSum3(TreeNode root, int sum) {
        if (root == null) return list;
        sum -= root.val;
        inner.add(root.val);  // 入列表
        if (root.left == null && root.right == null){
            if (sum == 0){
                list.add(new ArrayList<>(inner));  // 记得拷贝一份
            }

        }
        if (root.left != null)  pathSum3(root.left, sum);
        if (root.right != null)  pathSum3(root.right, sum);
        inner.remove(inner.size()-1);  //从列表中删除
        return list;
    }



    List<List<Integer>> result = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        if (root == null) {
            return result;
        } else if (sum == root.val && root.left == null && root.right == null) {
            List<Integer> path = new ArrayList<>();
            path.add(root.val);
            result.add(path);
        } else {
            List<Integer> path = new ArrayList<>();
            path.add(root.val);
            List<Integer> leftPath = new ArrayList<>(path);
            List<Integer> rightPath = new ArrayList<>(path);
            findInLeft(root, leftPath);
            findInRight(root, rightPath);
        }

        return result;

    }

    public void findInLeft(TreeNode root, List<Integer> path) {
        TreeNode left = root.left;
        if (left == null) {
            return;
        }
        path.add(left.val);
        int current = 0;
        for (Integer x : path) {
            current += x;
        }
        if (current == sum && left.left == null && left.right == null) {
            result.add(Collections.unmodifiableList(path));
        } else if (current < sum) {
            List<Integer> leftPath = new ArrayList<>(path);
            List<Integer> rightPath = new ArrayList<>(path);

            findInLeft(left, leftPath);
            findInRight(left, rightPath);
        }
    }

    public void findInRight(TreeNode root, List<Integer> path) {
        TreeNode right = root.right;
        if (right == null)
            return;
        path.add(right.val);
        int current = 0;
        for (Integer x : path) {
            current += x;
        }
        if (current == sum && right.left == null && right.right == null) {
            result.add(Collections.unmodifiableList(path));
        } else if (current < sum) {
            List<Integer> leftPath = new ArrayList<>(path);
            List<Integer> rightPath = new ArrayList<>(path);

            findInLeft(right, leftPath);
            findInRight(right, rightPath);
        }
    }

    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> paths=new ArrayList<List<Integer>>();
        go(root,0,sum,new ArrayList<Integer>(),paths);
        return paths;
    }

    private void go(TreeNode node,int sum,int target,ArrayList<Integer> path,List<List<Integer>> paths){
        if(node==null)return;
        sum+=node.val;
        path.add(node.val);
        //判断该路径和是否符合目标值
        if(sum==target&&node.left==null&&node.right==null){
            paths.add(new ArrayList<Integer>(path));
        }else{
            go(node.left,sum,target,path,paths);
            go(node.right,sum,target,path,paths);
        }
        //回溯
        path.remove(path.size()-1);
    }
}

