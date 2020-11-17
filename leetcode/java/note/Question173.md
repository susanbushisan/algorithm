思路

    又是二叉树，又是考基础。按照中根序遍历生成数组，然后内部维护数组
    
### 方法一：内部维护数组

~~~
    static class BSTIterator {
        List<Integer> mOrder = new ArrayList<>();
        int index = 0;

        public BSTIterator(TreeNode root) {
            order(root);
        }

        private void order(TreeNode root){
            if (root == null) {
                return;
            }
            order(root.left);
            mOrder.add(root.val);
            order(root.right);
        }

        /** @return the next smallest number */
        public int next() {
            return mOrder.get(index ++);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return index != mOrder.size();
        }
    }
~~~

具体实现:/src/Question173.java