这道题，难点在O(logN) 时间复杂度上，这就意味着不能扫描全部了
当然，最容易想到的是循环数组，找到后一个比前一个小的时候会产生峰值，如果最后一个是峰值特殊判断就好了

代码实现：src/Question162.findPeakElement  
时间复杂度为log(N),空间复杂度为log（1）

既然题目说要O（logN）那就必须O（logN），最先想到的肯定是二分法,那么根据连续性找到一个峰值就可以了

### 方法一：二分法

~~~
    public int findPeakElementBinarySearch(int[] nums) {
        int left = 0,right = nums.length-1;
        while (left < right){
            int mid = (left + right)/2;
            if (nums[mid] > nums[mid + 1]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
~~~

代码实现：src/Question162.findPeakElementBinarySearch  
时间复杂度为log(logN),空间复杂度为log（1）