import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Question85 {


    public static void main(String[] args) {
        Question85 q = new Question85();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        long start = System.currentTimeMillis();
        System.out.println(q.maximalRectangle(matrix));
        System.out.println(q.maximalRectangleSingleStack(matrix));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] help = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0 && matrix[i][j] == '1') {
                    help[i][j] = 1;
                    continue;
                }
                if (matrix[i][j] == '1') {
                    help[i][j] = help[i][j - 1] + 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < help.length; i++) {
            for (int j = 0; j < help[0].length; j++) {
                int w = help[i][j];
                int h = 1;
                res = Math.max(res, h * w);
                while (h < i + 1) {
                    h++;
                    w = Math.min(w, help[i + 1 - h][j]);
                    res = Math.max(res, h * w);
                }
            }
        }
        return res;
    }

    public int maximalRectangleSingleStack(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        //从上至下连续的1的个数
        int[][] help = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    help[0][j] = matrix[0][j] - '0';
                } else {
                    help[i][j] = matrix[i][j] == '1' ? help[i - 1][j] + 1 : 0;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < help.length; i++) {
            int[] h = help[i];

            Deque<Integer> stack = new ArrayDeque<>();

            for (int j = 0; j < h.length; j++) {
                while (!stack.isEmpty() && h[j] < h[stack.peek()]){
                    int curHeight = h[stack.pop()];
                    while (!stack.isEmpty() && curHeight == h[stack.peek()]){
                        stack.pop();
                    }
                    int curWidth;
                    if (stack.isEmpty()){
                        curWidth = j;
                    }else {
                        curWidth = j - stack.peek() - 1;
                    }
                    res = Math.max(res, curHeight * curWidth);
                }
                stack.push(j);

            }

            while (!stack.isEmpty()) {
                int curHeight = h[stack.pop()];
                while (!stack.isEmpty() && h[stack.peek()] == curHeight) {
                    stack.pop();
                }
                int curWidth;
                if (stack.isEmpty()) {
                    //最小元素的宽对应的是全部
                    curWidth = h.length;
                } else {
                    curWidth = h.length - stack.peek() - 1;
                }
                res = Math.max(res, curHeight * curWidth);
            }
        }
        return res;
    }


}
