package offer;

public class Offer66 {

    public int[] constructArr(int[] a) {
        if (a.length == 0){
            return new int[0];
        }
        int[] dp = new int[a.length];
        dp[0] = 1;
        for (int i = 1; i < a.length; i++) {
            dp[i] = dp[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            dp[i] *= temp;
        }
        return dp;
    }
}
