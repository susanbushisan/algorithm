
import java.util.ArrayList;
import java.util.List;

/**
 * n皇后问题
 */
public class Question51 {
    public static void main(String[] args) {
        Question51 q51 = new Question51();
        long start = System.currentTimeMillis();
        System.out.println(q51.solveNQueens(4));
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 思考：n占满n，所以每层都要有元素，遍历，一层一层找位置（hard基本满意）
     *
     */
    public List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] map = new char[n][n];
        deepSearch(map,0);
        return result;
    }

    private void deepSearch(char[][] current, int deep){
        for (int i = 0; i < current.length; i++) {
            if(current[deep][i] != '.'){
                char[][] clone = clone(current,i,deep);
                if (deep == current.length - 1){
                    List<String> temp = new ArrayList<>();
                    for (int j = 0; j < current.length; j++) {
                        temp.add(new String(clone[j]));
                    }
                    result.add(temp);
                    continue;
                }
                deepSearch(clone,deep + 1);
            }
        }
    }

    private char[][] clone(char[][] current, int point, int deep){
        int n = current.length;
        char[][] clone = new char[n][n];
        for(int i = 0;i < clone.length;i++){
            clone[i] = current[i].clone();
        }
        for (int i = 0; i < n; i++) {
            clone[deep][i] = '.';
        }
        clone[deep][point] = 'Q';
        for (int i = deep + 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == point){
                    clone[i][j] = '.';
                }
                if (i - deep == point - j ||i - deep == j - point){
                    clone[i][j] = '.';
                }
            }
        }
        return clone;
    }
}
