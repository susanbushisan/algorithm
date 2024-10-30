import util.TimerUtils;

import java.util.Arrays;

public class Question338 {
    public static void main(String[] args) {
        Question338 q = new Question338();
        System.out.println(Arrays.toString(TimerUtils.op(() -> q.countBits(5))));
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (i % 2 == 1) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = res[i >> 1];
            }
        }
        return res;
    }

}
