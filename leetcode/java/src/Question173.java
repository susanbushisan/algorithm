

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树迭代器
 *
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 */
public class Question173 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }

    /**
     * 初步思考，按照中根序遍历生成数组，然后内部维护数组
     */
    static class BSTIterator {
        List<Integer> mOrder = new ArrayList<>();
        int index = 0;

        public BSTIterator(TreeNode root) {
            order(root);
        }

        private void order(TreeNode root){
            if (root == null) {
                return;
            }
            order(root.left);
            mOrder.add(root.val);
            order(root.right);
        }

        /** @return the next smallest number */
        public int next() {
            return mOrder.get(index ++);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return index != mOrder.size();
        }
    }

}
