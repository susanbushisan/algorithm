public class Question33 {
    public static void main(String[] args) {
        Question33 q = new Question33();
        int[] nums = {2, 5, 6, 0, 1};
        long start = System.currentTimeMillis();
        System.out.println(q.search(nums, 0));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int searchI(int[] nums, int target) {
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

    public int search(int[] nums, int target) {
        int left = 0,right = nums.length - 1;

        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid]){
                if(nums[0] <= target && target < nums[mid]){
                    right = mid -1;
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

}
