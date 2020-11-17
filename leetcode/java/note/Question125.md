首先要得到过滤掉无效字符和数字，排除干扰条件，然后这就是一道简单的验证回文串的题目了。
验证回文一般有两种方法，反转或者双指针法

### 方法一：反转相等

~~~
    public boolean isPalindrome(String s) {
        StringBuilder original = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)){
                original.append(Character.toLowerCase(c));
            }
        }
        return new StringBuilder(original).reverse().toString().equals(original.toString());
    }
~~~

时间复杂度为O（s.length）,空间复杂度为O（s.length）

### 方法二：双指针

~~~
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

时间复杂度为O（s.length）,空间复杂度为O（1）