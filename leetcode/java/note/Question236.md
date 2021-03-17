### 方法一：递归

我们递归遍历整棵二叉树，定义有两种可能找到了答案
1. 该节点的左右子树分别找到了p,q
2. 该节点是p或q，且另外一个节点是该节点的子节点

~~~
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean f1 = dfs(root.left, p, q);
        boolean f2 = dfs(root.right, p, q);
        if ((f1 && f2) || ((root == p || root == q) && (f1 || f2))) {
            ans = root;
        }
        return f1 || f2 || root == p || root == q;
    }
~~~

时间复杂度为O(N),空间复杂度为O(N)

### 方法二：存储父节点

用hash表存所有节点的父节点，然后遍历取第一个交集

~~~
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> cache = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    cache.put(poll.left,poll);
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    cache.put(poll.right,poll);
                    queue.offer(poll.right);
                }
            }
        }
        Set<TreeNode> pNode = new HashSet<>();
        pNode.add(p);
        while (cache.get(p) != null){
            pNode.add(cache.get(p));
            p = cache.get(p);
        }
        while (q != null){
            if (pNode.contains(q)){
                return q;
            }
            q = cache.get(q);
        }
        return null;
    }
~~~

时间复杂度为O(N),空间复杂度为O(N)