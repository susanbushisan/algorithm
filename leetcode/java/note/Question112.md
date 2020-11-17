看题目是做过的类型题目，希望不要翻车.

递归是最简单的思想，同样迭代也可以做，不过是需要手动维护一个栈

### 方法一：递归

~~~
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
~~~

代码实现：src/Question112.java 

时间复杂度为：O（N），空间复杂度O（logN）（最大栈深度）