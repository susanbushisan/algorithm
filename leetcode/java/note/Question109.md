思考

    脾气不好，每次搜索重点都要用链表，麻烦，一遍遍历变成数组方便查询，然后算中位数位置并构造节点和作用子树
    
### 方法一：中心构建（递归）

~~~
 public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!= null){
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        TreeNode treeNode = toBST(arr);
        return treeNode;
    }

    private TreeNode toBST(int[] arr) {
        if (arr.length == 0){
            return null;
        }
        int center = arr.length / 2 + 1;
        TreeNode top = new TreeNode(arr[center - 1]);
        if (center != 1) {
            top.left = toBST(Arrays.copyOfRange(arr, 0, center - 1));
            top.right = toBST(Arrays.copyOfRange(arr, center, arr.length));
        }
        return top;
    }
~~~
代码实现：/src/Question109.java

时间复杂度O（N + N * log(N)）
空间复杂度O（logN）