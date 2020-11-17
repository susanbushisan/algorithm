思考

    题干的意思是一个有序的矩阵查找目标值，哪还有什么好说的，二分搜索走起

### 方法一：二分法

将二维数组转换成一个一维数组，然后使用二分搜索
~~~
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int[] array = new int[matrix.length * matrix[0].length];
        for (int n = 0; n < matrix.length; n++) {
            System.arraycopy(matrix[n], 0, array, n * matrix[n].length, matrix[n].length);
        }
        return Arrays.binarySearch(array, target) >= 0;
    }
~~~

具体实现:/src/Question74.java

时间复杂度为O(log mn)，这是二分搜索的时间复杂度
空间复杂度O（mn）用数组代替矩阵

### 方法二：原生二分法

用取模和取余计算出在矩阵的位置，然后就是正常的二分法

~~~
    public boolean searchMatrixR(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int left = 0, right = matrix.length * matrix[0].length - 1;

        while (left <= right){
            int mid = (left + right) / 2;
            int midVal = matrix[(mid/matrix[0].length)][(mid%matrix[0].length)];
            if (midVal == target){
                return true;
            }
            if (midVal < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }
~~~

时间复杂度为O(log mn)，这是二分搜索的时间复杂度
空间复杂度O（1），没有使用额外的空间