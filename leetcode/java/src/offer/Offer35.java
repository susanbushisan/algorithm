package offer;

import struct.ListNode;
import util.ListNodeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/ti-huan-kong-ge-lcof/">剑指 Offer 05. 替换空格</a>
 */
public class Offer35 {
    public static void main(String[] args) {
        Offer35 o = new Offer35();
        Node n = new Node(0);
        System.out.println(o.copyRandomList(n));
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        addMapping(head,map);
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            Node key = entry.getKey();
            Node value = entry.getValue();
            if (key.next != null){
                value.next = map.get(key.next);
            }
            if (key.random != null){
                value.random = map.get(key.random);
            }
        }
        return map.get(head);
    }

    private void addMapping(Node node, Map<Node, Node> map) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(node)) {
            map.put(node, new Node((node.val)));
        }else {
            return;
        }
        addMapping(node.next, map);
        addMapping(node.random, map);
    }
}
