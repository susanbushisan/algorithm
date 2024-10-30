import java.util.ArrayList;
import java.util.List;

public class Question120 {


    public static void main(String[] args) {
        Question120 q = new Question120();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> c1 = new ArrayList<>();
        c1.add(2);
        List<Integer> c2 = new ArrayList<>();
        c2.add(3);
        c2.add(4);
        List<Integer> c3 = new ArrayList<>();
        c3.add(5);
        c3.add(6);
        c3.add(7);
        List<Integer> c4 = new ArrayList<>();
        c4.add(4);
        c4.add(1);
        c4.add(8);
        c4.add(3);
        triangle.add(c1);
        triangle.add(c2);
        triangle.add(c3);
        triangle.add(c4);
        long start = System.currentTimeMillis();
        System.out.println(q.minimumTotal(triangle));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> integers = triangle.get(i);
            for (int j = 0; j < integers.size(); j++) {
                if (i == 0) {
                    dp[i][j] = integers.get(j);
                    break;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + integers.get(j);
                } else if (j == integers.size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + integers.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + integers.get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i : dp[triangle.size() - 1]) {
            min = Math.min(min, i);
        }
        return min;
    }

}
