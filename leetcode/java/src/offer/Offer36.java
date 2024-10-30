package offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/ti-huan-kong-ge-lcof/">剑指 Offer 05. 替换空格</a>
 */
public class Offer36 {
    public static void main(String[] args) {
        Offer36 o = new Offer36();
        Node n = new Node(0);
        System.out.println(o.treeToDoublyList(n));
    }

    static class Node {
        int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        Node head = null,node = null;
        Deque<Node> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 遍历操作
            if (head == null){
                head = root;
            }else {
                node.right = root;
                root.left = node;
            }
            node = root;
            root = root.right;
        }
        node.right = head;
        head.left = node;
        return head;
    }
}
