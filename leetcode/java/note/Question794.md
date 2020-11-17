思考

    规则那么多一个一个去解析呗，第一条规则X先放，第二条规则X和O交替，第三个规则，有连城线的旗子后游戏结束。根据规则去判断即可

### 方法一：大力出奇迹

~~~
    public boolean validTicTacToe(String[] board) {
        int xCount = 0,oCount = 0;
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == 'X') xCount ++;
                if (c == 'O') oCount ++;
            }
        }
        if (xCount - oCount != 0 &&xCount - oCount != 1) {
            return false;
        }
        int xline = 0,oline = 0;
        if (oCount >= 3){
            for (int i = 0; i < 3; i++) {
                if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(0) ==board[i].charAt(2)){
                    if (board[i].charAt(0) == 'X'){
                        xline++;
                    }else if (board[i].charAt(0) == 'O'){
                        oline ++;
                    }
                }
                if (board[0].charAt(i) == board[1].charAt(i) && board[0].charAt(i) ==board[2].charAt(i)){
                    if (board[0].charAt(i) == 'X'){
                        xline++;
                    }else if (board[0].charAt(i) == 'O'){
                        oline ++;
                    }
                }
            }

            if (board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) ==board[2].charAt(2)){
                if (board[0].charAt(0) == 'X'){
                    xline++;
                }else if (board[0].charAt(0) == 'O'){
                    oline ++;
                }
            }
            if (board[0].charAt(2) == board[1].charAt(1) && board[0].charAt(2) ==board[2].charAt(0)){
                if (board[0].charAt(2) == 'X'){
                    xline++;
                }else if (board[0].charAt(2) == 'O'){
                    oline ++;
                }
            }
            if (xline == 1){
                if (oline == 1){
                    return false;
                }
                return xCount != oCount;
            }
            if (oline == 1){
                return xCount == oCount;
            }

        }
        return true;
    }
~~~

时间复杂度和空间复杂度都为O（1）