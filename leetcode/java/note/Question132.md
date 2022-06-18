解题的思路是判断回文串。如果要分割的次数少的话那回文串要尽可能长。
先思考这样一个问题，如果分割次数最少，分割的字符串是包含该字符串最大子串？
下面这个字符串就违反了。`zwertyuioppoiuytrewqqwer`

那如何使分割次数最少。如果没有优化的思路，先来个暴力的。找出所有的分割方法，然后找最小值。

### 方案一：BF
~~~ java
     public int minCut(String s) {
        int length = s.length();
        if (isPalindromeRight(s)){
            return 0;
        }
        int min = length;
        for (int i = 0; i < length; i++) {
            String pre = s.substring(0,length - i);
            String suf = s.substring(length - i);
            if (isPalindromeRight(pre)){
                int times = minCut(suf) + 1;
                if (times  < min){
                    min = times;
                }
            }
        }
        return min;
    }

    public boolean isPalindromeRight(String s) {
        int start = 0,end = s.length() - 1;
        while (end  > start){
            while (end > start && !Character.isLetterOrDigit(s.charAt(start))){
                start ++;
            }
            while (end > start && !Character.isLetterOrDigit(s.charAt(end))){
                end --;
            }
            if (end > start){
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                    return false;
                }
                start ++;
                end --;
            }
        }
        return true;

    }
~~~
这个提交超时了，但是思路应该没有问题，需要想办法进行优化

##### 方法二：动态规划
~~~ java
    public int minCut(String s) {
        int length = s.length();
        // 计算该字符串0<i<=j<length的，i-j是否为回文
        boolean[][] g = new boolean[length][length];
        for (int i = 0; i < length; ++i) {
            Arrays.fill(g[i], true);
        }

        for (int i = length - 1; i >= 0; --i) {
            for (int j = i + 1; j < length; ++j) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }

        int[] f = new int[length];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < length; ++i) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[length - 1];
    }
~~~
这里用到了两次动态规划，第一次dp为了得到该字符串的子串是否是回文，第二部分是判断最小切割次数