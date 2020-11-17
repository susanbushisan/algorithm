思考

    典型的递归，如果要判断某个字符串是不是扰乱字符串，那么判断这两个字符串的子串是否互为扰乱字符串

### 方法一：深度优先遍历

~~~
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        //judgment char
        int[] a = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 97]++;
            a[s2.charAt(i) - 97]--;
        }
        for (int i : a) {
            if (i != 0) {
                return false;
            }
        }
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)) ||
                    isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                return true;
            }
        }
        return false;
    }
~~~
具体实现:/src/Question87.java

