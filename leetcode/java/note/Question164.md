思考

    根据题目可知，先排序然后找最大间距，思路告诉你了做就好了。
    
    但是，这是一道hard题，hard在说明部分的第二点，线性时间复杂度和空间复杂度完成就是O（n），排序的时间复杂度是 nlog（n）,完全达不到，
    那么要低于这个时间复杂度，就需要基于数据特征的排序了例如基数排序和桶排序
    
    
### 计数排序
~~~
    public int maximumGapCount(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        int min = nums[0],max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        boolean[] counter = new boolean[max -min + 1];
        for (int num : nums) {
            counter[num - min] = true;
        }
        int ans = 0,pre = -1;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i]){
                if (pre != -1){
                    ans = Math.max(ans,i - pre);
                }
                pre = i;
            }
        }
        return ans;
    }
~~~