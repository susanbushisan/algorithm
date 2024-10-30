import struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Question96 {


    public static void main(String[] args) {
        Question96 q = new Question96();

        long start = System.currentTimeMillis();
        System.out.println(q.numTrees(3));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i] + dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
