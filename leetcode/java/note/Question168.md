这就是除以n取余法算进制，这是一个26进制的返回值

### 方法一：除N取余

~~~
    public String convertToTitle(int n) {
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            char c = (char) ('A' + (n-1) % 26);
            ans.append(c);
            n = (n-1)/26;
        }
        return ans.reverse().toString();
    }
~~~

时间复杂度为O（logN）,空间复杂度为O（logN）