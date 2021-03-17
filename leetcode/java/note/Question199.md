第一想法想到了层序遍历，然后记录每层的第一个访问对象

### 方法一：层序遍历

~~~
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == size - 1){
                    res.add(poll.val);
                }
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }

        return res;
    }
~~~

时间复杂度为O(N),空间复杂度为O(N)