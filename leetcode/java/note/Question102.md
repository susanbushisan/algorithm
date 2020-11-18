之前有做过一道BFS困难题，回过头来看这道题是比较容易的，只需要层序遍历，用一个队列保存每层的节点，
然后每层出队这层的所有元素，并将不为null的叶子结点入队。当队列中没有元素就结束遍历。

### 方法一：层序遍历

~~~
    public List<List<Integer>> levelOrder(struct.TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Queue<struct.TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> current = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                struct.TreeNode poll = queue.poll();
                assert poll != null;
                current.add(poll.val);
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
            ans.add(current);
        }
        return ans;
    }
~~~

代码实现：src/Question102.java

时间复杂度为O(N)，每个元素遍历了一遍
空间复杂度为O(N),队列的长度最大为 N/2