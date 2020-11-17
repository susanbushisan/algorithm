思考

    有序查找，时间复杂度是 O(log n) ，第一反应，二分查找，结合题目，二分查找的变种

### 方法一：二分法
~~~
public int[] searchRange(int[] nums, int target) {
    int index = Arrays.binarySearch(nums, target);
    if(index < 0){
        return new int[]{-1,-1};
    }
    int first = index;
    int last = index;
    while (true) {
        if (first == 0) {
            break;
        }
        if(nums[first] == nums[first - 1]){
            first --;
        }else{
            break;
        }
    }
    while (true) {
        if (last == nums.length-1) {
            break;
        }
        if(nums[last] == nums[last + 1]){
            last ++;
        }else{
            break;
        }
    }
    return new int[]{first,last};
}
~~~

具体实现:/src/Question34.java

分析：
时间复杂度为 O(log n) ,空间复杂度为O(1) ，