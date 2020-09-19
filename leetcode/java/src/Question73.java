import java.util.Arrays;

public class Question73 {
    public static void main(String[] args) {
        Question73 q70 = new Question73();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {0, 10, 11, 12},
                {13, 14, 15, 0}
        };
        long start = System.currentTimeMillis();
        q70.setZeroes(matrix);
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 虽然效率不高，但是时间复杂度和空间复杂度低啊
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0){
                flag = true;
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flag){
                matrix[i][0] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

}
