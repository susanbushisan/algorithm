import java.util.*;

public class Question494 {

    public static void main(String[] args) {
        Question494 q = new Question494();
        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        long start = System.currentTimeMillis();
        System.out.println(q.findTargetSumWays(nums, 1));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }


}

