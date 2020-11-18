这道题似曾相识？不就是来回层序遍历嘛，who怕who

### 方法一：左右层序遍历

~~~
    public List<List<Integer>> zigzagLevelOrder(struct.TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<struct.TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        boolean direction = true;
        while (deque.size() > 0) {
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                struct.TreeNode treeNode = direction ? deque.pollLast() : deque.pollFirst();
                temp.add(treeNode.val);
                if (direction) {
                    if (treeNode.left != null) {
                        deque.addFirst(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        deque.addFirst(treeNode.right);
                    }
                } else {
                    if (treeNode.right != null) {
                        deque.addLast(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        deque.addLast(treeNode.left);
                    }
                }
            }
            direction = !direction;
            ans.add(temp);
        }

        return ans;
    }
~~~

代码实现 src/Question103.java

时间复杂度O(N),空间复杂度O(N)