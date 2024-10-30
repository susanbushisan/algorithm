package offer;

/**
 * <a href="https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof">剑指 Offer 04. 二维数组中的查找</a>
 */
public class Offer4 {
    public static void main(String[] args) {
        Offer4 o = new Offer4();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(o.findNumberIn2DArray(matrix, 5));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int x = 0, y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if ((matrix[x][y] > target)) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
