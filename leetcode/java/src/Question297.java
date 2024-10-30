import struct.TreeNode;
import util.TreeNodeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class Question297 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return "[]";
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            StringBuilder sb = new StringBuilder("[");
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node != null){
                    sb.append(node.val + ",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }else{
                    sb.append("null,");
                }
            }
            return sb.deleteCharAt(sb.length() - 1).append("]").toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if("[]".equals(data)) return null;
            String[] vals = data.substring(1,data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            int index = 1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(index < vals.length){
                TreeNode node = queue.poll();
                if(!"null".equals(vals[index])){
                    node.left = new TreeNode(Integer.parseInt(vals[index]));
                    queue.offer(node.left);
                }
                index++;
                if(!"null".equals(vals[index])){
                    node.right = new TreeNode(Integer.parseInt(vals[index]));
                    queue.offer(node.right);
                }
                index++;
            }
            return root;
        }
    }

    public static void main(String[] args) {

        TreeNode root = TreeNodeUtils.creatConventionalTreeNode(1, 2, 3, null, null, 4, 5);
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(root));

    }


}
