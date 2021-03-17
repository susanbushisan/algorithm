不要忽略二叉搜索树的定义

### 方法一：递归求解

~~~
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValidBST(TreeNode root, long upperBound, long lowerBound) {
        if (root == null) {
            return true;
        }
        if (root.val <= lowerBound || root.val >= upperBound) {
            return false;
        }
        return isValidBST(root.left, root.val, lowerBound) && isValidBST(root.right, upperBound, root.val);
    }
~~~

通过定义上界和下届来判读二叉树是否是搜索二叉树

时间复杂度O(N)  
空间复杂度O(N)

### 方法二：中序遍历

~~~
    long min = Long.MIN_VALUE;
    public boolean isValidBSTP(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean flag = isValidBSTP(root.left);
        if (flag){
            if (root.val <= min){
                return false;
            }else {
                min = root.val;
            }
        }else {
            return false;
        }
        return isValidBSTP(root.right);
    }
~~~

二叉搜索树中序遍历必定是有序的，根据定义可以推算出，那么中序遍历判断数据是否递增就可以得到结论

时间复杂度O(N)  
空间复杂度O(N)