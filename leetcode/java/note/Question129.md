关键字二叉树、遍历，一般这样的题目有两种解法，递归法和迭代法。理论上两者的时间复杂度是一样的，但是迭代法消耗的空间小。

### 方法一：深度优先遍历
~~~ java
    public int sumNumbers(TreeNode root) {
        return sumNumbersRecursion(root, 0);
    }

    private int sumNumbersRecursion(TreeNode root, int total) {
        int val = total + root.val;
        if (isLeaf(root)) {
            return val;
        }
        int res = 0;
        if (root.left != null) {
            res += sumNumbersRecursion(root.left, val * 10);
        }
        if (root.right != null) {
            res += sumNumbersRecursion(root.right, val * 10);
        }
        return res;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
~~~

### 方法二：广度优先遍历
~~~ java    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    /**
     * 广度优先遍历
     */
    public int sumNumbers(TreeNode root) {
        int res = 0;
        Queue<TreeNode> codeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        codeQueue.add(root);
        numQueue.add(root.val);
        while (!codeQueue.isEmpty()){
            for (int i = 0; i < codeQueue.size(); i++) {
                TreeNode node = codeQueue.poll();
                int num = numQueue.poll();
                if (isLeaf(node)){
                    res += num;
                }
                if (node.left != null) {
                    codeQueue.add(node.left);
                    numQueue.add(num * 10 + node.left.val);
                }
                if (node.right != null) {
                    codeQueue.add(node.right);
                    numQueue.add(num * 10 + node.right.val);
                }
            }
        }
        return res;
    }
~~~