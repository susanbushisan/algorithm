import java.util.Arrays;

public class Question1605 {

    public static void main(String[] args) {
        Question1605 q = new Question1605();
        long start = System.currentTimeMillis();
        int[] rowSum = {};
        int[] colSum = {};
        System.out.println(Arrays.deepToString(q.restoreMatrix(rowSum, colSum)));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int x = Math.min(rowSum[i], colSum[j]);
                ans[i][j] = x;
                rowSum[i] -= x;
                colSum[j] -= x;
            }
        }
        return ans;
    }
}
