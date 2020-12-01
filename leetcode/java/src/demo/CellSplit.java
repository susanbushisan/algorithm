package demo;

public class CellSplit {
    public static void main(String[] args) {
        CellSplit split = new CellSplit();
        long start = System.currentTimeMillis();
        System.out.println(split.split(40));
        System.out.println(System.currentTimeMillis() - start + "ms");
        start = System.currentTimeMillis();
        System.out.println(split.splitDp(40));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int split(int i) {
        if (i == 1) return 1;
        if (i == 2) return 2;
        if (i == 3) return 3;
        return split(i - 1) * 2 - split(i - 3);
    }

    public int splitDp(int i) {
        int[] dp = new int[i];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        for (int j = 3; j < i; j++) {
            dp[j] = dp[j - 1] * 2 - dp[j - 3];
        }
        return dp[i - 1];
    }
}
