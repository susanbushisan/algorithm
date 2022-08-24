### 方法一：除法

~~~ java
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
~~~
时间复杂度O(long n) ，空间复杂度为O(1)

### 方法二：判断是否为最大 33 的幂的约数
n的有效数字是32位，3的20次幂就超过了这个限制了，3^19=1162261467。可以判断n是不是1162261467的约数。
这个方法非正树
~~~ java
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
~~~

时间复杂度O(1) ，空间复杂度为O(1)