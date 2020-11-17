虽然做了前置题目了，但是还是没能解出来，二分法还没有吃透，相较于前置题，这题就增加了出现元素可重复，既然可以重复那么重复的
丢弃+1就行了，其它的还是二分法，时间复杂度上升到O（N）

### 方法一：二分法变种

~~~
    public boolean search(int[] nums, int target) {
        if (nums.length == 0){
            return false;
        }
        if (nums.length == 1){
            return nums[0] == target;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            //前半部分有序
            if (nums[left] < nums[mid]) {
                //target在前半部分
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {  //否则，去后半部分找
                    left = mid + 1;
                }
            } else {
                //后半部分有序
                //target在后半部分
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {  //否则，去后半部分找
                    right = mid - 1;

                }
            }
        }
        return false;

    }
~~~

代码实现：src/Question81.java

时间复杂度为O(n)
空间复杂度为O(1)