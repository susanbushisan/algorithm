这题和之前有一题蓄水池很像，不过并不能使用双指针进行计算，不过有一种方法是可以的，暴力计算，
以每个位置为中心找左右边界，通过左右边界计算出宽，然后乘以自身的高就可以得到当前位置最大面积
~~~java
public class Solution {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        // 特判
        if (len == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            // 找左边最后 1 个大于等于 heights[i] 的下标
            int left = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }
            // 找右边最后 1 个大于等于 heights[i] 的索引
            int right = i;
            while (right < len - 1 && heights[right + 1] >= curHeight) {
                right++;
            }

            int width = right - left + 1;
            res = Math.max(res, width * curHeight);
        }
        return res;
    }
}

~~~

不过这是一道hard题目，暴力做法基本上会超时。

既然会超时，那么就要想到用空间换时间，用单调栈是一个比较好的做法
