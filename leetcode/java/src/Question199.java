import struct.TreeNode;
import util.TreeNodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question199 {


    public static void main(String[] args) {
        Question199 q = new Question199();
        long start = System.currentTimeMillis();
        TreeNode treeNode = TreeNodeUtils.creatConventionalTreeNode(1, 2, 3, null, 5, null, 4);
        System.out.println(q.rightSideView(treeNode));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == size - 1){
                    res.add(poll.val);
                }
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }

        return res;
    }

}
