### 方法一：最小栈

利用最小栈的单调性找到答案和其映射值
~~~
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer,Integer> cache = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            cache.put(nums1[i], i);
        }
        stack.push(Integer.MAX_VALUE);
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        for (int value : nums2) {
            while (stack.peek() < value) {
                Integer pop = stack.pop();
                if (cache.containsKey(pop)){
                    ans[cache.get(pop)] = value;
                }
            }
            stack.push(value);
        }
        return ans;
    }
~~~

时间复杂度需要 O（M+N）
空间复杂度需要O（M+N）