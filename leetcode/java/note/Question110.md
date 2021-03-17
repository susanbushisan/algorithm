验证树的平衡一般有递归解法

### 方法一：自上而下递归

~~~
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node){
        if (node == null){
            return 0;
        }
        return Math.max(height(node.left),height(node.right)) + 1;
    }
~~~

递归逻辑为，如果当前树左右子树高度相差小于1，并且左右子树是平衡树则可以认为这是一颗平衡二叉树  
时间复杂度为O(N^2) ，空间复杂度为O(N),用于递归调用

### 方法二： 自下而上递归

~~~
public boolean isBalancedA(TreeNode root) {
        return heightA(root) >= 0;
    }

    public int heightA(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightA(root.left);
        int rightHeight = heightA(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
~~~

与之前不同处在于不用多次求树高  
时间复杂度为O(N) ，空间复杂度为O(N),用于递归调用