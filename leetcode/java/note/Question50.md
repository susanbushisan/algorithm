原谅我不厚道的想到，Math中有pow这个方法，那我参考一下方法然后自己实现一遍不就行了嘛？然后进去发现一个native方法，囧。那就自己来呗，把幂分为
3部分大于0等于0小于0，等于0永远返回1，如果一个数幂的绝对值相等符号相反，那结果互为倒数。那就算起来，跑了下test case，发现超时，暴力方法很尴尬

在答案我学到了分治法。中间被最小int坑了一下，因为*-1还是它本身，那就把n用long类型处理
~~~
    public double myPow(double x, int n) {
        long N = n;
        if (N == 0) return 1;
        boolean behindZero = true;
        if (N < 0) {
            behindZero = false;
            N = -N;
        }
        double ans = 1;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x;
            }
            x *= x;
            N = N << 1;
        }
        return behindZero ? ans : 1 / ans;
    }
~~~

代码实现：src/Question50,java

时间复杂度O（n）,空间复杂度为O(1)