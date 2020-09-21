import java.util.Arrays;
import java.util.Objects;

public class Question115 {
    public static void main(String[] args) {
        Question115 q = new Question115();
        String a = "babgbag";
        String b = "bag";

        long start = System.currentTimeMillis();
        System.out.println(q.numDistinct(a, b));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 最后答案求的是个数，那么这道题应该有DP解法
     */
    public int numDistinct(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        if (tLength > sLength){
            return 0;
        }
        if (s.equals(t)){
            return 1;
        }
        int[][] dp = new int[sLength][tLength];
        for (int i = 0; i < sLength ; i++) {
            for (int j = 0; j <= Math.min(tLength - 1, i); j++) {
                if (j == i) {
                    int temp = Objects.equals(s.substring(0, i + 1), t.substring(0, i + 1)) ? 1 : 0;
                    dp[i][j] = temp;
                    continue;
                }
                if (j == 0) {
                    int temp = s.charAt(i) == t.charAt(0) ? 1 : 0;
                    dp[i][0] = dp[i - 1][0] + temp;
                    continue;
                }
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[sLength - 1][tLength - 1];
    }
}
