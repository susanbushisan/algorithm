package demo;

import struct.TreeNode;
import util.TreeNodeUtils;

public class BinarySearchTree {

    public static TreeNode find(TreeNode root, int data){
        while (root != null){
            if (root.val > data){
                root = root.left;
            }else if (root.val < data){
                root = root.right;
            }else {
                return root;
            }
        }
        return null;
    }

    public static TreeNode insert(TreeNode root, int data){
        if (root == null){
            return new TreeNode(data);
        }
        TreeNode p = root;

        while (true){
            if (p.val > data){
                if (p.left == null){
                    p.left = new TreeNode(data);
                    return root;
                }
                p = p.left;
            }else {
                if (p.right == null){
                    p.right = new TreeNode(data);
                    return root;
                }
                p = p.right;
            }
        }
    }

    public static TreeNode delete(TreeNode root, int data){
        //3种情况
        TreeNode current = root;
        TreeNode pre = null;
        while (current != null && current.val != data){
            if (current.val > data){
                pre = current;
                current = current.left;
            }else {
                pre = current;
                current = current.right;
            }
        }

        if (current == null){
            return root;
        }

        //2个节点
        if (current.left != null && current.right != null){
            TreeNode minP = current.right;
            TreeNode minPP = current;
            while (minP.left != null){
                minPP = minP;
                minP = minP.left;
            }

            current.val = minP.val;
            current = minP;
            pre = minPP;
        }

        //1个节点
        TreeNode child = null;
        if (current.left == null){
            child = current.right;
        }else if (current.right == null){
            child = current.left;
        }

        if (pre == null){
            return child;
        }else if (pre.left == current){
            pre.left = child;
        }else{
            pre.right = child;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.creatConventionalTreeNode(33, 17, 50, 13, 18, 34, 58, null, 16, null, 25, null, null, 51, 66, null, null, 19,27);
        TreeNode ans = find(treeNode, 19);
        TreeNodeUtils.printAsTree(treeNode);
        TreeNodeUtils.printAsTree(ans);

        TreeNode insert = insert(treeNode, 20);
        TreeNodeUtils.printAsTree(insert);

        TreeNode delete = delete(treeNode, 17);
        TreeNodeUtils.printAsTree(delete);
    }
}
