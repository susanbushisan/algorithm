看题目是找全部符合条件的集合，那么基本上是用栈进行回溯去做，栈用来存当前集合就可以了，如果栈中所有数之和等于给定的target，那么讲栈中的集合存到答案当中
然后继续寻找。由于元素可以重合出现了多次计算的问题，可以改变下一步递归的字典值。

### 方法一：回溯法

~~~
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        helper(candidates, target, stack, ans);
        return ans;
    }

    private void helper(int[] candidates, int target, LinkedList<Integer> stack, List<List<Integer>> ans) {
        for (int i = 0; i < candidates.length; i++) {
            int candidate = candidates[i];
            stack.push(candidate);
            if (candidate == target) {
                ans.add(new ArrayList<>(stack));
            } else if (candidate < target) {
                int[] arr =  new int[candidates.length - i];
                System.arraycopy(candidates,i,arr,0,arr.length);
                helper(arr, target - candidate, stack, ans);
            }
            stack.pop();
        }
    }
~~~

时间复杂度为递归的for循环O（N^2）,空间复杂度为O（N^2）