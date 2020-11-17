原地算法，拿考验基本功了，有序可以和上一个进行比较判断

### 方法一：双指针法
快指针代表遍历，慢指针代表修改，如果快指针碰到当前元素和上一个元素相等，那么慢指针修改并+1
~~~
public int removeDuplicates(int[] nums) {
    if(nums.length == 0){
        return 0;
    }
    int index = 1;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i - 1] != nums[i]){
            nums[index] = nums[i];
            index ++;
        }
    }
    return index;
}
~~~

代码实现：src/Question26.java

事件复杂度为O（n），空间复杂度为O(1)