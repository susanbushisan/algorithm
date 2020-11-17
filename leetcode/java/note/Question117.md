思考

    广度优先遍历才能满足条件

### 方法一：广度优先遍历

使用一个队列记录每个深度的全部元素

~~~
   public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        while (Q.size() > 0) {
            int size = Q.size();
            for(int i = 0; i < size; i++) {
                Node node = Q.poll();
                if (i < size - 1) {
                    node.next = Q.peek();
                }
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
        }

        return root;

    }
~~~


代码实现 src/Question117.java

时间复杂度为O(N)，空间复杂度为Q（N）
