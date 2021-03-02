思考：
    乍一看像是动态规划，实际上发现找不到转移方程，只能作罢。

### 方法一： 使用柱状图的优化暴力方法

~~~
    public int maximalRectangle(char[][] matrix) {
         if (matrix.length == 0 || matrix[0].length == 0){
             return 0;
         }
         int[][] help = new int[matrix.length][matrix[0].length];
         for (int i = 0; i < matrix.length; i++) {
             for (int j = 0; j < matrix[0].length; j++) {
                 if (j == 0 &&matrix[i][j] == '1'){
                     help[i][j] = 1;
                     continue;
                 }
                 if (matrix[i][j] == '1'){
                     help[i][j] = help[i][j-1] + 1;
                 }
             }
         }
         int res = 0;
         for (int i = 0; i < help.length; i++) {
             for (int j = 0; j < help[0].length; j++) {
                 int w = help[i][j];
                 int h = 1;
                 res = Math.max(res, h * w);
                 while (h < i + 1){
                     h ++;
                     w = Math.min(w,help[i + 1 - h][j]);
                     res = Math.max(res, h * w);
                 }
             }
         }
         return res;
     }
~~~

具体实现src/Question85.java

时间复杂度为O(M * N^2)，空间复杂度为O(M * N)

### 方法二：单调栈

~~~
int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int j = 0; j < n; j++) { // 对于每一列，使用基于柱状图的方法
            int[] up = new int[m];
            int[] down = new int[m];

            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ret = Math.max(ret, area);
            }
        }
        return ret;
~~~

时间复杂度为O(M * N)，空间复杂度为O(M * N)