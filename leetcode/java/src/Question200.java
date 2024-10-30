
public class Question200 {
    public static void main(String[] args) {
        Question200 q63 = new Question200();

        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        long start = System.currentTimeMillis();
        System.out.println(q63.numIslands(grid));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !flag[i][j]) {
                    flag[i][j] = true;
                    stain(i, j, grid, flag);
                    count++;
                }
            }
        }
        return count;
    }

    private void stain(int i, int j, char[][] grid, boolean[][] flag) {
        if (i != 0 && !flag[i - 1][j] && grid[i - 1][j] == '1') {
            flag[i - 1][j] = true;
            stain(i - 1, j, grid, flag);
        }
        if (j != 0 && !flag[i][j - 1] && grid[i][j - 1] == '1') {
            flag[i][j - 1] = true;
            stain(i, j - 1, grid, flag);
        }
        if (i != grid.length - 1 && !flag[i + 1][j] && grid[i + 1][j] == '1') {
            flag[i + 1][j] = true;
            stain(i + 1, j, grid, flag);
        }
        if (j != grid[0].length - 1 && !flag[i][j + 1] && grid[i][j + 1] == '1') {
            flag[i][j + 1] = true;
            stain(i, j + 1, grid, flag);
        }
    }
}
