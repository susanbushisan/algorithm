package offer;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof">剑指 Offer 29. 顺时针打印矩阵</a>
 */
public class Offer29 {
    public static void main(String[] args) {
        Offer29 o = new Offer29();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(o.spiralOrder(matrix)));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int boundUp = 0, boundDown = matrix.length , boundLeft = 0, boundRight = matrix[0].length;
        int current = 0;
        while (true){
            if (boundUp==boundDown){
                break;
            }
            for (int k = boundLeft; k < boundRight; k++) {
                res[current++] = matrix[boundUp][k];
            }
            boundUp++;
            if (boundLeft == boundRight){
                break;
            }
            for (int k = boundUp; k < boundDown; k++) {
                res[current++] = matrix[k][boundRight -1];
            }
            boundRight--;
            if (boundUp==boundDown){
                break;
            }
            for (int k = boundRight - 1; k >= boundLeft; k--) {
                res[current++] = matrix[boundDown - 1][k];
            }
            boundDown--;
            if (boundLeft == boundRight){
                break;
            }
            for (int k = boundDown - 1; k >= boundUp; k--) {
                res[current++] = matrix[k][boundLeft];
            }
            boundLeft++;
        }
        return res;
    }
}
