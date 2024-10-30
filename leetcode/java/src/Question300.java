import java.util.ArrayDeque;
import java.util.Deque;

public class Question300 {

    public static void main(String[] args) {
        Question300 q = new Question300();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        long start = System.currentTimeMillis();
        System.out.println(q.lengthOfLIS(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}