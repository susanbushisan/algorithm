
public class Question79 {
    public static void main(String[] args) {
        Question79 q = new Question79();
        char[][] board = {
                {'A', 'B'},
                {'C', 'D'}
        };
        String word = "BDCA";

        long start = System.currentTimeMillis();
        System.out.println(q.exist(board, word));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public boolean existI(char[][] board, String word) {
        boolean[][] exist = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    exist[i][j] = true;
                    if (helper(board, word, i, j, exist, 1)) {
                        return true;
                    }
                    exist[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, String word, int x, int y, boolean[][] exist, int current) {
        if (current == word.length()) {
            return true;
        }
        char c = word.charAt(current);
        //上左下右
        if (x > 0 && !exist[x - 1][y] && c == board[x - 1][y]) {
            exist[x - 1][y] = true;
            if (helper(board, word, x - 1, y, exist, current + 1)) {
                return true;
            }
            exist[x - 1][y] = false;
        }
        if (y < board[0].length - 1 && !exist[x][y + 1] && c == board[x][y + 1]) {
            exist[x][y + 1] = true;
            if (helper(board, word, x, y + 1, exist, current + 1)) {
                return true;
            }
            exist[x][y + 1] = false;
        }
        if (x < board.length - 1 && !exist[x + 1][y] && c == board[x + 1][y]) {
            exist[x + 1][y] = true;
            if (helper(board, word, x + 1, y, exist, current + 1)) {
                return true;
            }
            exist[x + 1][y] = false;
        }

        if (y > 0 && !exist[x][y - 1] && c == board[x][y - 1]) {
            exist[x][y - 1] = true;
            if (helper(board, word, x, y - 1, exist, current + 1)) {
                return true;
            }
            exist[x][y - 1] = false;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] path = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    path[i][j] = true;
                    if (help(board, word, path, i, j, 1)) {
                        return true;
                    }
                    path[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean help(char[][] board, String word, boolean[][] path, int x, int y, int index) {
        if (index == word.length()) {
            return true;
        }
        boolean canUp = x != 0, canRight = y != path[0].length - 1, canDown = x != path.length -1 , canLeft = y != 0;
        if (canLeft && !path[x][y - 1] && word.charAt(index) == board[x][y - 1]) {
            path[x][y - 1] = true;
            if (help(board, word, path, x, y - 1, index + 1)){
                return true;
            }
            path[x][y - 1] = false;
        }
        if (canDown && !path[x + 1][y] && word.charAt(index) == board[x + 1][y]) {
            path[x + 1][y] = true;
            if (help(board, word, path, x + 1, y, index + 1)) {
                return true;
            }
            path[x + 1][y] = false;
        }
        if (canRight && !path[x][y + 1] && word.charAt(index) == board[x][y + 1]) {
            path[x][y + 1] = true;
            if (help(board, word, path, x, y + 1, index + 1)) {
                return true;
            }
            path[x][y + 1] = false;
        }
        if (canUp && !path[x - 1][y] && word.charAt(index) == board[x - 1][y]) {
            path[x - 1][y] = true;
            if (help(board, word, path, x - 1, y, index + 1)) {
                return true;
            }
            path[x - 1][y] = false;
        }

        return false;

    }

}
