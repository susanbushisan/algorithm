import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question37 {
    public static void main(String[] args) {
        Question37 question37 = new Question37();

        char[][] obstacleGrid = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        long start = System.currentTimeMillis();
        question37.solveSudoku(obstacleGrid);
        System.out.println(Arrays.deepToString(obstacleGrid));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public void solveSudoku(char[][] board) {
        boolean[][] rowUsed = new boolean[9][9];
        boolean[][] colUsed = new boolean[9][9];
        boolean[][][] boxUsed = new boolean[3][3][9];
        // 初始化
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int num = board[row][col] - '1';
                if (0 <= num && num < 9) {
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row / 3][col / 3][num] = true;
                }
            }
        }
        // 递归尝试填充数组 
        recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, 0, 0);
    }

    private boolean recusiveSolveSudoku(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boxUsed, int row, int col) {
        // 边界校验, 如果已经填充完成, 返回true, 表示一切结束
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9) {
                return true;
            }
        }
        // 是空则尝试填充, 否则跳过继续尝试填充下一个位置
        if (board[row][col] == '.') {
            // 尝试填充1~9
            for (int num = 0; num < 9; num++) {
                boolean canUsed = !(rowUsed[row][num] || colUsed[col][num] || boxUsed[row / 3][col / 3][num]);
                if (canUsed) {
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row / 3][col / 3][num] = true;

                    board[row][col] = (char) ('1' + num);
                    if (recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, row, col + 1)) {
                        return true;
                    }
                    board[row][col] = '.';

                    rowUsed[row][num] = false;
                    colUsed[col][num] = false;
                    boxUsed[row / 3][col / 3][num] = false;
                }
            }
        } else {
            return recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, row, col + 1);
        }
        return false;

    }

    /**
     * 也许只有神威·太湖之光才能解出来
     */
    public void solveSudokuError(char[][] board) {
        boolean[][] flag = new boolean[9][9];
        solveSudoku(board, 0, 0, flag);
    }

    public boolean solveSudoku(char[][] board, int col, int row, boolean[][] flag) {
        if (col == 9) {
            col = 0;
            row++;
        }
        if (col == 8 && row == 8) {
            return true;
        }
        if (board[row][col] != '.') {
            solveSudoku(board, col + 1, row, flag);
        }
        for (int i = 0; i < 9; i++) {
            board[row][col] = (char)('0' + i);
            if (solveSudoku(board, col + 1, row, flag)) {
                return true;
            } else {
                board[row][col] = '.';
            }
        }



        return false;

    }


}
