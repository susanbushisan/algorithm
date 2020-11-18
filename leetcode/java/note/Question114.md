好吧，我只能找到O（n）空间复杂度的解法，O（1）是参考了答案的，将节点的右子树拼在左子树的右叶子节点为空的后面，然后旋转子树，如果左子树为null那么
向右子树迭代

### 方法一：原地算法

~~~
    public void flatten(struct.TreeNode root) {
        while (root != null){
            if (root.left != null){
                struct.TreeNode temp = root.left;
                while (temp.right != null){
                    temp = temp.right;
                }
                temp.right = root.right;
                root.right = root.left;
                root.left = null;
            }else {
                root = root.right;
            }
        }
    }
~~~

时间复杂度为O（N），空间复杂度为O（1）