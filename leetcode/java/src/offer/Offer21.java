package offer;

public class Offer21 {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right){
            while (left < right && (nums[left] & 1) == 0) {
                swap(nums, left, right);
                right--;
            }
            left ++;
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
