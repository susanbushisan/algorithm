import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question309 {

    public static void main(String[] args) {
        Question309 q = new Question309();
        int[] prices = {10, 9, 2, 5, 3, 7, 101, 18};
        long start = System.currentTimeMillis();
        System.out.println(q.maxProfit(prices));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < n; ++i) {
            int newf0 = Math.max(f0, f2 - prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1, f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }

        return Math.max(f1, f2);
    }
}
