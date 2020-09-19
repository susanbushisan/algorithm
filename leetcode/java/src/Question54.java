import java.util.ArrayList;
import java.util.List;

public class Question54 {
    public static void main(String[] args) {
        Question54 question54 = new Question54();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        long start = System.currentTimeMillis();
        System.out.println(question54.spiralOrder(matrix));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int left = 0, right = matrix[0].length, bottom = matrix.length, top = 0;
        while (true) {
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (bottom == top) {
                return res;
            }
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right - 1]);
            }
            right--;
            if (right == left) {
                return res;
            }
            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[bottom - 1][i]);
            }
            bottom--;
            if (bottom == top) {
                return res;
            }
            for (int i = bottom - 1; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (right == left) {
                return res;
            }
        }
    }

}
