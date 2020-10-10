public class Question81 {
    public static void main(String[] args) {
        Question81 q = new Question81();
        int[] nums = {1, 3, 1, 1, 1};
        long start = System.currentTimeMillis();
        System.out.println(q.search(nums, 3));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 看到这个search就想到2分法
     */
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

}
