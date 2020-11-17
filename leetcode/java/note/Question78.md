
### 方法一：深度优先遍历

老实说，这类题目做多了会有感觉的，这题典型的深度优先遍历，跟着思路写就好了，难怪通过率这么高。
给定数组不会重复，代表dfs也不会重复

~~~
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if (nums.length == 0){
            return ans;
        }
        Deque<Integer> stack = new LinkedList<>();
        bfs(nums,0,stack,ans);
        return ans;
    }

    private void bfs(int[] nums, int index, Deque<Integer> stack, List<List<Integer>> ans){
        for (int i = index; i < nums.length; i++) {
            stack.push(nums[i]);
            ans.add(new ArrayList<>(stack));
            bfs(nums,i + 1,stack,ans);
            stack.pop();
        }
    }
~~~

代码实现：src/Question78.java

时间复杂度为O(n * 2^n),空间复杂度为栈递归的O（n）