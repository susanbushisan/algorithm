这道题简直是典中典，二分查找。作为算法的基本功之一，做不出来是假的，但是能够不调试的情况下写对也不是很
容易的，之前学习的时候有个口诀帮助二分查找进行边界判断。如果要形成肌肉记忆还是需要将其好好背下来。

### 方法一：二分查找

~~~ java
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
~~~