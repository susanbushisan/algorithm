思考

    进阶中都告诉你至少有三种解法了，第一种就是拿一个相同的二维数组去存改变后的值，遍历原数组，最后覆盖，第二种是创建两个数组
    数组分别记录标0的行和列，然后第二遍循环在覆盖至，第三种有点难想到，需要O(1)那么肯定是要在原数组上改动才能达到，那么可以
    将行和列的第一个元素标0，然后从右下到左上进行覆盖值
    
    
### 方法一：原地算法

~~~
    public void setZeroes(int[][] matrix) {
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0){
                flag = true;
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flag){
                matrix[i][0] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
~~~

代码实现：src/Question73.java 