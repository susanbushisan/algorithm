package offer;

import struct.TreeNode;
import util.TreeNodeUtils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/ti-huan-kong-ge-lcof/">剑指 Offer 05. 替换空格</a>
 */
public class Offer37 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        String serialize = codec.serialize(TreeNodeUtils.creatConventionalTreeNode(1, 2, 3, null, null, 4, 5));
        System.out.println(serialize);
        TreeNodeUtils.printPreorder(codec.deserialize(serialize));
    }

    public static class Codec {

        private TreeNode nullNode = new TreeNode();

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null){
                return "null";
            }
            StringBuilder sb = new StringBuilder();
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                int size = stack.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = stack.poll();
                    if (sb.length() != 0) {
                        sb.append(',');
                    }
                    if (poll == nullNode) {
                        sb.append("null");
                    } else {
                        sb.append(poll.val);
                        stack.offer(poll.left == null ? nullNode : poll.left);
                        stack.offer(poll.right == null ? nullNode : poll.right);
                    }
                }
            }
            return sb.toString();

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            List<Integer> list = Arrays.stream(data.split(",")).map(x -> {
                if ("null".equals(x)) {
                    return null;
                }
                return Integer.parseInt(x);
            }).collect(Collectors.toList());
            if (list.size() == 0 || list.get(0) == null) {
                return null;
            }
            TreeNode root = new TreeNode(list.get(0));
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int index = 1;
            while (index < list.size() && !queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (list.get(index) != null) {
                    TreeNode node = new TreeNode(list.get(index));
                    poll.left = node;
                    queue.offer(node);
                }
                if (index + 1 < list.size() && list.get(index + 1) != null) {
                    TreeNode node = new TreeNode(list.get(index + 1));
                    poll.right = node;
                    queue.offer(node);
                }
                index += 2;
            }
            return root;
        }
    }
}
