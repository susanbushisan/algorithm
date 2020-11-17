想要时间复杂度为O（logN），第一个想到的是二分搜索，这道题也正好是有序的，只是没有找到边界，那么可以通过二分先找到边界，
然后寻找目标值。  
很难受，脑子想到了二分法，但是代码写了好久都没弄出来，普通的二分查找写了几遍都没用，只要参考一下答案了，答案果然不出我所料，
就是怼二分搜索，只是我没有怼出来，还是要加强编码能力

### 方法一：二分法变种
~~~
public int search(int[] nums, int target) {
    if (nums.length == 0){
        return -1;
    }
    if (nums.length == 1){
        return nums[0] == target ? 0: -1;
    }
    int left = 0,right = nums.length - 1;
    while (left <= right){
        int mid = (left + right) / 2;
        if (nums[mid] == target){
            return mid;
        }
        if (nums[0] <= nums[mid]){
            if (nums[0] <= target && target < nums[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }else {
            if (nums[nums.length - 1] >= target && target > nums[mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
    }

    return -1;
}
~~~

代码实现：src/Question33.java

时间复杂度为O（log n）
空间复杂度为O（1）