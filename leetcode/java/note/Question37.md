开始的时候走了弯路，希望计算出每个位置可填的数，再遍历这些数，这个时间复杂度大到不可思议，结果就是算不出来，后面根据提示，
看到了和布隆过滤器相似的做法，bitMap进行回溯，ac

### 方法一：回溯

~~~
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
~~~

代码实现：src/Question.solveSudokuError;src/Question.solveSudoku;