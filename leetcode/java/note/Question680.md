### 方法一:双指针

~~~
    public boolean validPalindrome(String s) {
        int deleteCount = 1;
        int low = 0 ,high = s.length() - 1;
        while (low != high &&low != high + 1){
            if (s.charAt(low) == s.charAt(high)){
                low ++;
                high --;
            }else {
                if (deleteCount > 0){
                    deleteCount --;
                    if (validPalindrome(s.substring(low,high))||validPalindrome(s.substring(low + 1,high + 1))){
                        return true;
                    }
                }else {
                    return false;
                }
            }
        }
        return true;
    }
~~~

时间复杂度O（N）
空间复杂度O（1）