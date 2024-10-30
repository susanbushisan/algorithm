public class Question279 {
    public static void main(String[] args) {
        Question279 q = new Question279();
        long start = System.currentTimeMillis();
        System.out.println(q.numSquares(12));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, dp[i - j * j]);
            }
            dp[i] = minn + 1;
        }
        return dp[n];
    }

}
