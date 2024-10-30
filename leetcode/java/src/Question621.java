import java.util.Arrays;

public class Question621 {
    public static void main(String[] args) {
        Question621 q = new Question621();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        long start = System.currentTimeMillis();
        System.out.println(q.leastInterval(tasks, 2));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    public int leastInterval(char[] tasks, int n) {
        int[][] dp = new int[26][2];
        for (int i = 0; i < 26; i++) {
            dp[i][1] = 1;
        }
        for (char task : tasks) {
            dp[task - 'A'][0] += 1;
        }

        int time = 1;
        while (true) {
            int maxIndex = -1;
            boolean flag = false;
            for (int i = 0; i < 26; i++) {
                if (dp[i][0] > 0){
                    flag = true;
                } else if (dp[i][1] <= time) {
                    if (maxIndex == -1 || dp[maxIndex][0] < dp[i][0]) {
                        maxIndex = i;
                    }
                }
            }
            time++;
            if (!flag){
                break;
            }
            if (maxIndex == -1) {
                continue;
            }
            dp[maxIndex][0]--;
            dp[maxIndex][1] += n;
        }
        return time;
    }
}
