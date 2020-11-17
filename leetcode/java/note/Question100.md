思考

    思路 如果有树为null则可以判断是否相同，如果另一棵树为null则相同否则不同，然后依次判断当前节点数据是否相同，左节点树是否相同，又节点树是否相同

### 方法一：递归

~~~
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null){
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
~~~

具体实现:/src/Question100.java

时间复杂度为O(min(m,n))其中 mm 和 nn 分别是两个二叉树的节点数。对两个二叉树同时进行深度优先搜索，只有当两个二叉树中的对应节点都不为空时才会访问到该节点，因此被访问到的节点数不会超过较小的二叉树的节点数。


空间复杂度为O(min(m,n))，其中 mm 和 nn 分别是两个二叉树的节点数。空间复杂度取决于递归调用的层数，递归调用的层数不会超过较小的二叉树的最大高度，最坏情况下，二叉树的高度等于节点数。
