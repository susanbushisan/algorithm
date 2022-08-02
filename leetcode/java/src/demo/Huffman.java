package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {

    public String huffman(String text) {
        // 分析文本以及频次
        Map<Character, Integer> timesForText = new HashMap<>();
        for (char c : text.toCharArray()) {
            timesForText.compute(c, (k, v) -> v == null ? 1 : ++v);
        }
        System.out.println("------打印频次------");
        timesForText.forEach((k, v) -> System.out.println(k + ":" + v));
        System.out.println("-------end---------");
        // 构建树
        Node root = buildMinTree(timesForText);
        // 遍历树生成编码
        Map<Character, String> encoder = getEncoder(root);
        System.out.println("------打印编码------");
        encoder.forEach((k, v) -> System.out.println(k + ":" + v));
        System.out.println("-------end---------");
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(encoder.getOrDefault(c, ""));
        }
        decode(encoder, sb.toString());
        decode(root, sb.toString());
        return sb.toString();
    }

    private void decode(Map<Character, String> encoder, String toString) {
        Map<String, Character> temp = new HashMap<>();
        encoder.forEach((k, v) -> temp.put(v, k));
        int start = 0, end = 1;
        StringBuilder result = new StringBuilder();
        while (start != toString.length()) {
            String substring = toString.substring(start, end);
            if (temp.containsKey(substring)) {
                result.append(temp.get(substring));
                start = end;
                end = start + 1;
                continue;
            }
            end++;
        }
        System.out.println("-----decode by code table------");
        System.out.println(result);
        System.out.println("------------end----------------");
    }

    private void decode(Node root, String toString) {
        Node temp = root;
        StringBuilder result = new StringBuilder();
        for (char c : toString.toCharArray()) {
            if (c == '0'){
                if (temp.left.isLeaf){
                    result.append(temp.left.ch);
                    temp = root;
                }else {
                    temp = temp.left;
                }
            }else {
                if (temp.right.isLeaf){
                    result.append(temp.right.ch);
                    temp = root;
                }else {
                    temp = temp.right;
                }
            }
        }

        System.out.println("-----decode by code tree------");
        System.out.println(result);
        System.out.println("------------end----------------");
    }

    private Map<Character, String> getEncoder(Node root) {
        Map<Character, String> encodingForChar = new HashMap<>();
        helper(encodingForChar, root, "");
        return encodingForChar;
    }

    private void helper(Map<Character, String> result, Node node, String encoder) {
        if (node.isLeaf) {
            result.put(node.ch, encoder);
            return;
        }
        helper(result, node.left, encoder + "0");
        helper(result, node.right, encoder + "1");
    }

    private Node buildMinTree(Map<Character, Integer> timesForText) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        timesForText.forEach((k, v) -> queue.add(new Node(k, v)));
        while (queue.size() != 1) {
            Node node1 = queue.poll();
            Node node2 = queue.poll();
            queue.add(new Node(node1, node2, node1.times + node2.times));
        }
        return queue.poll();
    }

    static class Node implements Comparable<Node> {
        char ch;
        int times;
        boolean isLeaf;
        Node left;
        Node right;

        public Node(char ch, int times) {
            this.ch = ch;
            this.times = times;
            this.isLeaf = true;
        }

        public Node(Node left, Node right, int times) {
            this.left = left;
            this.right = right;
            this.times = times;
            isLeaf = false;
        }

        @Override
        public int compareTo(Node o) {
            return times - o.times;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Huffman().huffman("rh934hr9rgun9fuwgs9rh89w4ht8wyebf8werbg8weyrbfw8ydbf8ywqehrg89qheffu8dqbfiobwiyfbuyiwerybfhsdbfohqrefhiy"));
    }


}
