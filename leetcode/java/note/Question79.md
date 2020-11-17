好吧，我看出来了，这是一道图的题目，搜索的话我回溯法应该有一席之地.


###方法一：回溯法
果不其然,核心方法就是不断的回溯

~~~
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
~~~

代码实现：src/Question79.java

时间复杂度为O(M\*N*L^3) M和N为border的宽和高，L 为字符串 word 的长度，空间复杂度为O(M\*N)