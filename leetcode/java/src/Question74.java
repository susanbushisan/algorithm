

import java.util.Arrays;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class Question74 {
    public static void main(String[] args) {
        Question74 q = new Question74();
        int[][] grid = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        long start = System.currentTimeMillis();
        System.out.println(q.searchMatrixR(grid, 3));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 直觉告诉我是二分查找
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int[] array = new int[matrix.length * matrix[0].length];
        for (int n = 0; n < matrix.length; n++) {
            System.arraycopy(matrix[n], 0, array, n * matrix[n].length, matrix[n].length);
        }
        return Arrays.binarySearch(array, target) >= 0;
    }

    public boolean searchMatrixR(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int left = 0, right = matrix.length * matrix[0].length - 1;

        while (left <= right){
            int mid = (left + right) / 2;
            int midVal = matrix[(mid/matrix[0].length)][(mid%matrix[0].length)];
            if (midVal == target){
                return true;
            }
            if (midVal < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }
}
