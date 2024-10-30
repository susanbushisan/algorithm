package offer;

import util.ArrayUtil;

public class Offer12 {

    public static void main(String[] args) {
        char[][] board = {
//                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
                {'a'}
        };
        Offer12 o = new Offer12();
        System.out.println(o.exist(board, "a"));
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, word, i, j, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int x, int y, int idx, boolean[][] flag) {
        if (board[x][y] != word.charAt(idx)) {
            return false;
        }else if (idx == word.length() - 1){
            return true;
        }
        flag[x][y] = true;
        if (x > 0 && !flag[x - 1][y]) {
            if (exist(board, word, x - 1, y, idx + 1, flag)) {
                return true;
            }
        }
        if (y < board[0].length - 1 && !flag[x][y + 1]) {
            if (exist(board, word, x, y + 1, idx + 1, flag)) {
                return true;
            }
        }
        if (x < board.length - 1 && !flag[x + 1][y]) {
            if (exist(board, word, x + 1, y, idx + 1, flag)) {
                return true;
            }
        }
        if (y > 0 && !flag[x][y - 1]) {
            if (exist(board, word, x, y - 1, idx + 1, flag)) {
                return true;
            }
        }
        flag[x][y] = false;
        return false;
    }
}
