public class Question32 {


    public static void main(String[] args) {
        Question32 q = new Question32();
        long start = System.currentTimeMillis();
        System.out.println(q.longestValidParentheses("(()"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    /**
     * dp 解法和堆栈解法
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    int before = i == 2 ? 0 : dp[i - 2];
                    dp[i] = before + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 +  (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

}
