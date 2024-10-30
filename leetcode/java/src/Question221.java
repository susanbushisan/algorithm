import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question221 {
    public static void main(String[] args) {
        Question221 q = new Question221();
        char[][] matrix = {{'0', '1',}, {'1', '0'}};
        long start = System.currentTimeMillis();
        System.out.println(q.maximalSquare(matrix));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public int maximalSquare(char[][] matrix) {
        int[][] edge = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0 || matrix[i][j] == '0') {
                    edge[i][j] = matrix[i][j] - '0';
                } else {
                    edge[i][j] = Math.min(edge[i - 1][j], Math.min(edge[i][j - 1], edge[i - 1][j - 1])) + 1;
                }
                max = Math.max(edge[i][j], max);
            }
        }
        return max * max;
    }

}
