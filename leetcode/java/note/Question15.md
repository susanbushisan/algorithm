思考
    
      和第一题比较相似，不过这次是求三数之和，可以使用双指针法将时间复杂的降为O(N^2)
      
### 方法一：双指针

~~~
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    do {
                        right--;
                    } while (right >= i && nums[right] == nums[right + 1]);
                    do {
                        left++;
                    } while (left < nums.length - 1 && nums[left] == nums[left - 1]);
                } else if (nums[left] + nums[right] > target) {
                    do {
                        right--;
                    } while (right >= i && nums[right] == nums[right + 1]);
                } else {
                    do {
                        left++;
                    } while (left < nums.length - 1 && nums[left] == nums[left - 1]);
                }
            }
            do {
                i++;
            } while (i < nums.length - 2 && nums[i] == nums[i - 1]);
        }

        return res;
    }
~~~

具体实现:/src/Question15.java



分析：
时间复杂度为O(N^2),
空间复杂度为O(1) 