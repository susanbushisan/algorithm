package offer;

public class Offer10_2 {

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        }
        int n_2 = 1, n_1 = 1;
        for (int i = 2; i <= n; i++) {
            int r = (n_2 + n_1) % 1000000007;
            n_2 = n_1;
            n_1 = r;
        }
        return n_1;
    }
}
