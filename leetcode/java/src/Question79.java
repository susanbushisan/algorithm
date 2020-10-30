
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

    public boolean exist(char[][] board, String word) {
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

}
