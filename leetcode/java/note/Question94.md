二叉树，它又来了。看起来不难，用递归的方法最直接
~~~
    print(node){
        print(node.left);
        ans.add(node.val);
        print(node.right);
    }
        
~~~
但是题目建议用迭代做，那就用迭代吧，迭代就是用代码中栈代替递归压栈，如果左子树不为空那么就压栈并操作左子树
如果左子树为空，那么就出栈，当栈中没有元素那么就结束

上面是两种常见的做法，代码参考src/Question94.inorderTraversal,src/Question94.inorderTraversalRecursion

两者的时间复杂度都为O（n），空间复杂度为O（n），栈所用空间

#### 骚操作

~~~ java
publc class Solution {
    public List<Integer> inorderTraversal(struct.TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        struct.TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                
                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
~~~

Morris 遍历算法是另一种遍历二叉树的方法，它能将非递归的中序遍历空间复杂度降为 O(1)O(1)。

Morris 遍历算法整体步骤如下（假设当前遍历到的节点为 xx）：

- 如果 xx 无左孩子，先将 xx 的值加入答案数组，再访问 xx 的右孩子，即 x = x.\textit{right}x=x.right。
- 如果 xx 有左孩子，则找到 xx 左子树上最右的节点（即左子树中序遍历的最后一个节点，xx 在中序遍历中的前驱节点），我们记为 \textit{predecessor}predecessor。根据 \textit{predecessor}predecessor 的右孩子是否为空，进行如下操作。
  - 如果 \textit{predecessor}predecessor 的右孩子为空，则将其右孩子指向 xx，然后访问 xx 的左孩子，即 x = x.\textit{left}x=x.left。
  - 如果 \textit{predecessor}predecessor 的右孩子不为空，则此时其右孩子指向 xx，说明我们已经遍历完 xx 的左子树，我们将 \textit{predecessor}predecessor 的右孩子置空，将 xx 的值加入答案数组，然后访问 xx 的右孩子，即 x = x.\textit{right}x=x.right。
- 重复上述操作，直至访问完整棵树。
