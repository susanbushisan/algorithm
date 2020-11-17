简单题就有能直观思考到的方法，变成二进制然后计算1的个数不就好了嘛时间复杂度和空间复杂度都是O（1）没意义

### 方法一：数字符

~~~
    public int hammingWeight(int n) {
        int count = 0;
        String s = Integer.toBinaryString(n);
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
~~~


既然题目后面疯狂暗示我有更好的解法，那么我就尝试一下,除2取余法，如果余数为1的话结果+1，如果n
为负数，那么取反，然后用32-结果

### 方法二：位运算

~~~

    public int hammingWeightRight(int n) {
        int count = 0;
        boolean flag = true;
        if (n < 0) {
            flag = false;
            n = ~n;
        }
        while (n != 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }
        return flag ? count : 32 - count;
    }

~~~