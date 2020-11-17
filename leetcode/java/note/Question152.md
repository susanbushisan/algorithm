思考

    以每个数组坐标为起点向后寻找最大乘积，从前到后再从后到前寻找最大连续乘积两种方式实现
    重新碰到这道题，发现还有DP解法，并且效率高于以上两种

### 方法一：大力出奇迹

每个位置找乘积然后比较大小

~~~
    public int maxProduct(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int j = i; j  < nums.length; j++) {
                if (nums[j] == 0){
                    max = Math.max(max, 0);
                    break;
                }
                temp*=nums[j];
                if (temp > max){
                    max = temp;
                }
            }
        }
        return max;
    }
~~~

时间复杂度为O（N^2）
空间复杂度都是O(1)

### 方法二：动态规划

~~~
    public int maxProductDp(int[] nums) {
        int length = nums.length;
        int max = nums[0],min = nums[0],res = max;
        for (int i = 1; i < length; i++) {
            int mx = max,mn = min,current = nums[i];
            max = Math.max(mx * current,Math.max(current,current*mn));
            min = Math.min(mx * current,Math.min(current,current*mn));
            res = Math.max(max,res);
        }
        return res;
    }
~~~


时间复杂度为O(N)
空间复杂度都是O(1)