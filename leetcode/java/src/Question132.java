import java.util.Arrays;

public class Question132 {
    public static void main(String[] args) {
        Question132 q = new Question132();
        String s = "aaba";

        long start = System.currentTimeMillis();
        System.out.println(q.minCut(s));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int minCut(String s) {
        int length = s.length();
        // 计算该字符串0<i<=j<length的，i-j是否为回文
        boolean[][] g = new boolean[length][length];
        for (int i = 0; i < length; ++i) {
            Arrays.fill(g[i], true);
        }

        for (int i = length - 1; i >= 0; --i) {
            for (int j = i + 1; j < length; ++j) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }

        int[] f = new int[length];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < length; ++i) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[length - 1];
    }

}
