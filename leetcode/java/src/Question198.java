
/**
 * 位1的个数
 */
public class Question198 {


    public static void main(String[] args) {
        Question198 q = new Question198();
        int[] nums = {1, 2, 3, 1};
        long start = System.currentTimeMillis();
        System.out.println(q.rob(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i - 2 < 0) {
                dp[i] = nums[i];
            } else if (i - 3 < 0) {
                dp[i] = nums[i] + dp[i - 2];
            } else {
                dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            }
        }
        return Math.max(dp[nums.length - 2], dp[nums.length - 1]);

    }


}
