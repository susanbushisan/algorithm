思考：

    有n个旗子在n*n的棋盘上，说明在每一列上都必须有且只有一个棋子才能符合条件，这样我可以遍历在第一排的任何地方放置第一个棋子，并将它能辐射到的地方标记为不能放置棋子，当我能放置n行的时候就代表找到了n皇后的解

### 方法一：每行占满

~~~
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
~~~

### 方法二：数位压缩法

利用一个int数组代表结果

~~~
    public List<List<String>> solveNQueensBacktracking(int n) {
        int[] map = new int[n];
        List<List<String>> result = new ArrayList<>();
        deepSearch(map,0,result);

        return result;
    }

    private void deepSearch(int[] map, int deep, List<List<String>> result) {
        if (deep == map.length){
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < map.length; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < map.length; k++) {
                    sb.append(map[j] == k?"Q":".");
                }
                temp.add(sb.toString());
            }
            result.add(temp);
            return;
        }
        for (int i = 0; i < map.length; i++) {
            boolean canFill = true;
            for (int j = 0; j < deep; j++) {
                if (map[j] == i || map[j] + deep - j == i || map[j] - deep + j == i) {
                    canFill = false;
                    break;
                }
            }
            if (canFill){
                map[deep] = i;
                deepSearch(map, deep + 1, result);
            }
        }
    }
~~~

具体实现:/src/Question51.java

分析：
时间复杂度为O(n^2),空间复杂度为O（n^2）