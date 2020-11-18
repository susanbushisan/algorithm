### 方法一：深度优先遍历

~~~
    public List<Double> averageOfLevels(struct.TreeNode root) {
        Map<Integer, List<Integer>> process = new TreeMap<>();
        List<Double> result = new ArrayList<>();
        findChildLevel(root, 0,process);

        process.forEach((k, v) -> result.add(v.stream().mapToDouble(e->e).average().getAsDouble()));
        return result;
    }

    private void findChildLevel(struct.TreeNode root, int i,Map<Integer, List<Integer>> process) {
        if (root != null) {
            if (process.get(i) == null) {
                List<Integer> list = new LinkedList<>();
                list.add(root.val);
                process.put(i, list);
            } else {
                process.get(i).add(root.val);
            }
            findChildLevel(root.left, i + 1,process);
            findChildLevel(root.right, i + 1,process);
        }
    }
~~~



分析：  
时间复杂度：O(N)。  其中 N 是树中的节点个数。
空间复杂度：O(M)其中 M 是树中每一层节点个数的最大值，即为广度优先搜索中使用队列存储同一层节点需要的空间。

### 方法二：栈

~~~
    public List<Double> averageOfLevelsT(struct.TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<struct.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            double sum = 0.0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                struct.TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
            result.add(sum/size);
        }

        return result;

    }
~~~

分析：  
时间复杂度：O(N)。  其中 N 是树中的节点个数。
空间复杂度：O(M)其中 M 是树中每一层节点个数的最大值，即为广度优先搜索中使用队列存储同一层节点需要的空间。