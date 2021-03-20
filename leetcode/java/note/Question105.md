### 方法一：暴力递归

~~~
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return reConstructBinaryTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode reConstructBinaryTreeHelper(int[] pre, int preLeft, int preRight, int[] in, int inLeft, int inRight) {
        if (preLeft >= preRight) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preLeft]);
        int i = inLeft;
        for (; i < inRight; i++) {
            if (in[i] == pre[preLeft]) {
                break;
            }
        }
        node.left = reConstructBinaryTreeHelper(pre, preLeft + 1, preLeft + 1 + i - inLeft, in, inLeft, i);
        node.right = reConstructBinaryTreeHelper(pre, preLeft + 1 + i - inLeft, preRight, in, i +1, inRight);
        return node;
    }
~~~

相比于之前的版本，少了数组拷贝，取而代之的是下标法，所以减少了很大一部分内存
时间复杂度为O(N),空间复杂度为O(N)
