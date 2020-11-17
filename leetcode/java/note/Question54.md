思考

    既然是螺旋，那怎么旋转我代码怎么写，找数据只有四种情况，右下左上，那可以设置边界约束遍历指针，从一个边界到达另一个边界
    最后跳出的条件就是某个边界重合了

### 方法一：边界求解

一次进行右下左上的路劲走到边界，如果边界重合代表已经遍历完成跳出循环
~~~
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int left = 0, right = matrix[0].length, bottom = matrix.length, top = 0;
        while (true) {
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (bottom == top) {
                return res;
            }
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right - 1]);
            }
            right--;
            if (right == left) {
                return res;
            }
            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[bottom - 1][i]);
            }
            bottom--;
            if (bottom == top) {
                return res;
            }
            for (int i = bottom - 1; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (right == left) {
                return res;
            }
        }
    }
~~~
代码实现：/src/Question54.java

分析  
时间复杂度为O（mn），每个数被找到一次，空间复杂度为O（1），除去结果，额外只有4个边界