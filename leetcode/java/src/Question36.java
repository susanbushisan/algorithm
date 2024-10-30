import java.util.HashSet;
import java.util.Set;

public class Question36 {
    public static void main(String[] args) {
        Question36 q63 = new Question36();

        char[][] obstacleGrid = new char[][]{
                {'.', '.', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'1', '.', '.', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '.', '2', '.', '6', '.', '.'},
                {'.', '9', '.', '.', '.', '.', '.', '7', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        long start = System.currentTimeMillis();
        System.out.println(q63.isValidSudoku(obstacleGrid));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public boolean isValidSudokuI(char[][] board) {

        for (int i = 0; i < 9; i++) {
            Set<Character> colspan = new HashSet<>();
            Set<Character> rowspan = new HashSet<>();
            Set<Character> block = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char col = board[i][j];
                char row = board[j][i];
                if (col != '.' && colspan.contains(col)) {
                    return false;
                } else {
                    colspan.add(col);
                }
                if (row != '.' && rowspan.contains(row)) {
                    return false;
                } else {
                    rowspan.add(row);
                }
            }
            int x = i / 3, y = i % 3;
            for (int a = 3 * x; a < 3 * x + 3; a++) {
                for (int b = 3 * y; b < 3 * y + 3; b++) {
                    char c = board[a][b];
                    if (c != '.' && block.contains(c)) {
                        return false;
                    } else {
                        block.add(c);
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> colSet = new HashSet<>();
            Set<Character> rowSet = new HashSet<>();
            Set<Character> spanSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && colSet.contains(board[i][j])) {
                    return false;
                }
                colSet.add(board[i][j]);
                if (board[j][i] != '.' && rowSet.contains(board[j][i])) {
                    return false;
                }
                rowSet.add(board[j][i]);
                int x = (i / 3) * 3 + j / 3;
                int y = (i % 3) * 3 + j % 3;
                if (board[x][y] != '.' && spanSet.contains(board[x][y])) {
                    return false;
                }
                spanSet.add(board[x][y]);
            }

        }
        return true;
    }

}
