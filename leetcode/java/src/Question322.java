import java.util.Arrays;

public class Question322 {

    public static void main(String[] args) {
        Question322 q = new Question322();
        int[] coins = {411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422};
        long start = System.currentTimeMillis();
        System.out.println(q.coinChange(coins, 9864));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
