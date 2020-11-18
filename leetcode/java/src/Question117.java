

import struct.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Question117 {


    public static void main(String[] args) {
        Question117 q = new Question117();
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(7);
        long start = System.currentTimeMillis();
        System.out.println(q.connect(root));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        while (Q.size() > 0) {
            int size = Q.size();
            for(int i = 0; i < size; i++) {
                Node node = Q.poll();
                if (i < size - 1) {
                    node.next = Q.peek();
                }
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
        }

        return root;

    }
}
