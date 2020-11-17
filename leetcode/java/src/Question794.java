

public class Question794 {

    public static void main(String[] args) {
        Question794 q794 = new Question794();
        String[] board = {
                "OXX",
                "XOX",
                "OXO"
        };
        long start = System.currentTimeMillis();
        System.out.println(q794.validTicTacToe(board));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }


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
}
