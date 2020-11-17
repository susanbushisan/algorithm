思考

    动态规划，只能向右下就代表机器人的横纵坐标只能加，可以用动态规划算到最后一个格子的可达路劲

###方法一：动态规划
~~~
    private int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < obstacleGrid.length; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        for(int i = 1; i <obstacleGrid.length; i ++ ){
            for(int j = 1; j <obstacleGrid[i].length; j ++ ){
                if(obstacleGrid[i][j] == 0){
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }else{
                     obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
~~~

分析：
时间复杂度为O(mn),空间复杂度为O（1）