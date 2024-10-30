import util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Question240 {
    public static void main(String[] args) {
        Question240 q = new Question240();
        int[][] matrix = ArrayUtil.creatTwoDimensionalArray("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]");
        long start = System.currentTimeMillis();
        System.out.println(q.searchMatrix(matrix, 5));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int right = matrix[0].length - 1;
        for (int[] ints : matrix) {
            if (ints[0] > target) {
                return false;
            }
            int left = 0;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (ints[mid] == target) {
                    return true;
                } else if (ints[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return false;
    }

}
