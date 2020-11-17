其本质是求最小路径，那么我有一个大胆且暴力的想法

貌似有路劲阻拦，我又有一个大胆的想法，动态规划,但是没有规划出来找到转移方程

开始想使用三维dp的，但是受路径影响无法建立转移方程

后面根据题解发现可以倒着使用dp，这样就不会受路径影响，因为只能向右和向下

### 方法一：反向dp

~~~
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n -1] = Math.max(0, -dungeon[m - 1][n - 1]);

        // 设置最后一列的值
        for (int i = m - 2; i >= 0; --i) {
            int needMin = dp[i + 1][n - 1] - dungeon[i][n - 1];
            dp[i][n -1] = Math.max(0, needMin);
        }

        // 设置最后一行的值
        for (int i = n - 2; i >= 0; --i) {
            int needMin = dp[m - 1][i + 1] - dungeon[m - 1][i];
            dp[m - 1][i] = Math.max(0, needMin);
        }

        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                // 从右边和下边选择一个最小值，然后减去当前的 dungeon 值
                int needMin = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(0, needMin);
            }
        }


        return dp[0][0] + 1;
    }
~~~