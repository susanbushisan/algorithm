思考

    最小路劲，经典dp算法应用。
    
### 方法一：动态规划

~~~
public int minPathSum(int[][] grid) {
     for (int n = 0; n < grid.length; n++) {
         for (int m = 0; m < grid[n].length; m++) {
             if (n == 0 && m == 0) {
                 continue;
             }
             if (m == 0) {
                 grid[n][0] += grid[n - 1][0];
                 continue;
             }
             if (n == 0) {
                 grid[0][m] += grid[0][m - 1];
                 continue;
             }
             grid[n][m] += Math.min(grid[n - 1][m], grid[n][m - 1]);

         }
     }

     return grid[grid.length - 1][grid[0].length - 1];
 }
~~~

具体实现:/src/Question64.java

时间复杂度O(mn)
空间复杂度O(1) 借助本身实现，没有使用新空间