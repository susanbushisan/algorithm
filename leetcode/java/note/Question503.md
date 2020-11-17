
朴素解法，每个元素往后找，找到第一个比自己大的就赋值结束这次循环，如果找了一圈没找到就赋值-1

### 方法一：暴力法

~~~
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                int index = i + j >= nums.length ? i + j - nums.length : i + j;
                if (nums[i] < nums[index]) {
                    result[i] = nums[index];
                    break;
                }
                if (j == result.length - 1) {
                    result[i] = -1;
                }
            }
        }
        return result;
    }
~~~

分析：  
时间复杂度：O(N^2)。  
空间复杂度：O(1)



单调栈解法，如果当前元素大于栈顶元素就弹出，将元素入栈，如果是空栈res为-1，不是则为栈顶元素值，循环2n次后结束输出答案

### 方法二：单调栈

~~~
    public int[] nextGreaterElements3(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length * 2 - 1; i ++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                res[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return res;
    }
~~~

分析：  
时间复杂度：O(N)。  
空间复杂度：O(N)

