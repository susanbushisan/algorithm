思考

    简答题比较友好，友好到我在别的地方看过，应该是学习java基础的时候讲递归的例子，那就递归好了，3行搞定，然后发现超时了QAQ
    那咋办呢，我又心生一计，DP算法正好解决此问题
    
### 方法一：递归


~~~
    public int climbStairsTimeOut(int n) {
        if (n == 1 || n == 0){
            return 1;
        }
        return climbStairsTimeOut(n-2) + climbStairsTimeOut(n-1);
    }
~~~
    
代码实现：/src/Question70.climbStairsTimeOut，

分析

递归超时的原因为递归的时间复杂度为O（n^2）,空间复杂度为O（1）

### 方法二：动态规划

~~~
    public int climbStairs(int n) {
        if (n == 1 || n == 0){
            return 1;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i -2] + arr[i - 1];
        }
        return arr[n -1];
    }
~~~

分析
代码实现：/src/Question70.climbStairs
而DP的时间复杂度为O（n），空间复杂度为O（1）