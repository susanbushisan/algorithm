
/**
 * 找最小路径
 */
public class Question64 {
    public static void main(String[] args) {
        Question64 q = new Question64();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        long start = System.currentTimeMillis();
        System.out.println(q.minPathSum(grid));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 第一想法,经典动态规划
     */
    public int minPathSum(int[][] grid) {
        for (int n = 0; n < grid.length; n++) {
            for (int m = 0; m < grid[n].length; m++) {
                if (n == 0 && m == 0) {
                    continue;
                }
                if (m == 0) {
                    grid[n][0] += grid[n - 1][0];
                    continue;
                }
                if (n == 0) {
                    grid[0][m] += grid[0][m - 1];
                    continue;
                }
                grid[n][m] += Math.min(grid[n - 1][m], grid[n][m - 1]);

            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

}
