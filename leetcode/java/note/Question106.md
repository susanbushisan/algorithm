数据结构基础题，大学在考试的时候给出具体的数据算出来过，但是写算法还是第一次

### 方法一：暴力递归

通过后序遍历的最后一个值可以得到树的root节点，然后更具中序确定左子树和右子树，然后递归调用自己

~~~
    public TreeNode buildTreeSlow(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        int val = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(val);
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == val) {
                break;
            }
        }

        int[] inorderLeft = Arrays.copyOf(inorder, i);
        int[] postorderLeft = Arrays.copyOf(postorder, i);
        root.left = buildTree(inorderLeft, postorderLeft);
        int[] inorderRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        int[] postorderRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);
        root.right = buildTree(inorderRight, postorderRight);
        return root;
    }
~~~

### 方法二：迭代

- 我们用一个栈和一个指针辅助进行二叉树的构造。初始时栈中存放了根节点（后序遍历的最后一个节点），指针指向中序遍历的最后一个节点；
- 我们依次枚举后序遍历中除了第一个节点以外的每个节点。如果 index 恰好指向栈顶节点，那么我们不断地弹出栈顶节点并向左移动 index，并将当前节点作为最后一个弹出的节点的左儿子；如果 index 和栈顶节点不同，我们将当前节点作为栈顶节点的右儿子；
- 无论是哪一种情况，我们最后都将当前的节点入栈。

~~~
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }
~~~

时间复杂度为O（N）  
空间复杂度为O（N）