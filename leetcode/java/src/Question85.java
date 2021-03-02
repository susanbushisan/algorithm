import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Question85 {


    public static void main(String[] args) {
        Question85 q = new Question85();
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        long start = System.currentTimeMillis();
        System.out.println(q.maximalRectangle(matrix));
        System.out.println(q.maximalRectangleSingleStack(matrix));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][] help = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0 &&matrix[i][j] == '1'){
                    help[i][j] = 1;
                    continue;
                }
                if (matrix[i][j] == '1'){
                    help[i][j] = help[i][j-1] + 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < help.length; i++) {
            for (int j = 0; j < help[0].length; j++) {
                int w = help[i][j];
                int h = 1;
                res = Math.max(res, h * w);
                while (h < i + 1){
                    h ++;
                    w = Math.min(w,help[i + 1 - h][j]);
                    res = Math.max(res, h * w);
                }
            }
        }
        return res;
    }

    public int maximalRectangleSingleStack(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int j = 0; j < n; j++) { // 对于每一列，使用基于柱状图的方法
            int[] up = new int[m];
            int[] down = new int[m];

            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }


}
