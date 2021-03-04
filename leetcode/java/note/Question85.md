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
    public int maximalRectangleSingleStack(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        //从上至下连续的1的个数
        int[][] help = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    help[0][j] = matrix[0][j] - '0';
                } else {
                    help[i][j] = matrix[i][j] == '1' ? help[i - 1][j] + 1 : 0;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < help.length; i++) {
            int[] h = help[i];

            Deque<Integer> stack = new ArrayDeque<>();

            for (int j = 0; j < h.length; j++) {
                while (!stack.isEmpty() && h[j] < h[stack.peek()]){
                    int curHeight = h[stack.pop()];
                    while (!stack.isEmpty() && curHeight == h[stack.peek()]){
                        stack.pop();
                    }
                    int curWidth;
                    if (stack.isEmpty()){
                        curWidth = j;
                    }else {
                        curWidth = j - stack.peek() - 1;
                    }
                    res = Math.max(res, curHeight * curWidth);
                }
                stack.push(j);

            }

            while (!stack.isEmpty()) {
                int curHeight = h[stack.pop()];
                while (!stack.isEmpty() && h[stack.peek()] == curHeight) {
                    stack.pop();
                }
                int curWidth;
                if (stack.isEmpty()) {
                    //最小元素的宽对应的是全部
                    curWidth = h.length;
                } else {
                    curWidth = h.length - stack.peek() - 1;
                }
                res = Math.max(res, curHeight * curWidth);
            }
        }
        return res;
     }
~~~

时间复杂度为O(M * N)，空间复杂度为O(M * N)