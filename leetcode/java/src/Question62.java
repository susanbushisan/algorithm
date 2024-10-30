public class Question62 {
    public static void main(String[] args) {
        Question62 q = new Question62();
        long start = System.currentTimeMillis();
        System.out.println(q.uniquePaths(3, 7));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];

            }
        }
        return dp[m - 1][n - 1];
    }
}
