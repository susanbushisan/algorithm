### 方法一：动态规划
推导转移方程
$$
    f(n)=f(n-1)+\sum_{i = 0}^m{a_i} - ma_{m-n}
$$
~~~ java
    public int maxRotateFunction(int[] nums) {
        int length = nums.length;
        int sum = 0;
        int numsCount = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i] * i;
            numsCount += nums[i];
        }
        int max = sum;
        for (int i = 1; i < length; i++) {
            sum = sum + numsCount - length * nums[length - i];
            max = Math.max(sum, max);
        }

        return max;
    }
~~~

时间复杂度是O(n)
空间复杂度为O(1)