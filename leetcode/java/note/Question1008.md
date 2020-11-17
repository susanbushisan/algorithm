### 方法一：递归复制数组

~~~
    public TreeNode buildTree(int[] pre, int[] ord) {
        if (pre.length == 0 || ord.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0; i < ord.length; i++) {
            if (ord[i] == pre[0]) {
                treeNode.left = buildTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(ord, 0, i));
                treeNode.right = buildTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(ord, i + 1, ord.length));
            }
        }
        return treeNode;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] order = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(order);
        return buildTree(preorder, order);
    }
~~~

### 方法二： 递归

~~~
    public TreeNode bstFromPreorderN(int[] preorder) {
        return helper(preorder,0,preorder.length);
    }

    private TreeNode helper(int[] preorder,int start,int end){
        if (start == end) return null;
        TreeNode node = new TreeNode(preorder[start]);
        for (int i = start + 1; i < end; i++) {
            if (preorder[i] > preorder[start]){
                node.left = helper(preorder,start + 1, i);
                node.right = helper(preorder,i, end);
                return node;
            }
        }
        node.left = helper(preorder,start + 1, end);
        return node;
    }
~~~

时间复杂度为：O(N *longN) N 为元素的个数
空间复杂度： O(longN) 递归所需要的栈空间