package offer;

import struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Offer34 {


    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        helper(root, target, stack, res);
        return res;
    }

    private void helper(TreeNode node, int target, Deque<Integer> stack, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        stack.offerLast(node.val);
        target -= node.val;
        if (node.left == null && node.right == null && target == 0) {
            res.add(new ArrayList<>(stack));
        }
        helper(node.left, target, stack, res);
        helper(node.right, target, stack, res);
        stack.pollLast();
    }


}
