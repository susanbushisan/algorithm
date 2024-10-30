package offer;

public class Offer42 {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = pre > 0 ? nums[i] + pre : nums[i];
            max = Math.max(max, pre);
        }
        return max;
    }
}
