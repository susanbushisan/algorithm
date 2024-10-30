import struct.TreeNode;
import util.TreeNodeUtils;

import java.util.*;

public class Question226 {


    public static void main(String[] args) {
        Question226 q = new Question226();
        long start = System.currentTimeMillis();
        TreeNode treeNode = TreeNodeUtils.creatConventionalTreeNode(4,2,7,1,3,6,9);
        System.out.println(q.invertTree(treeNode));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }
}
