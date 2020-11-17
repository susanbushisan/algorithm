终于接触到数独相关的算法题了，之前我很喜欢玩数独，但是对于高阶数独解法不是很懂，希望后面有能解数独的题目

### 方法一:暴力破解
既然只需要验证当前已有数独的正确性，那就根据3条规则霸蛮就好了，每种验证都是有9次，那么可以写在一个循环里面

~~~
public boolean isValidSudoku(char[][] board) {

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
~~~

时间复杂度和空间复杂度都为O（1）