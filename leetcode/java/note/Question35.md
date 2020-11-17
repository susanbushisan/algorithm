二分搜索的变种，考验基本功的时候又到了。

好吧，基本功不是太熟，参考原代码写的。插值的位置正好是low指针的位置

### 方法一：二分搜索

可以参考jdk实现

~~~
public int searchInsert(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (high >= low) {
        int mid = (high + low) >>> 1;
        int num = nums[mid];
        if (num == target) {
            return mid;
        }
        if (num < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return low;
}
~~~


时间复杂度为O(logN),空间复杂度O(1)