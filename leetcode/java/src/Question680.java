

/**
 * 一次删除机会判断回文
 */
public class Question680 {
    public static void main(String[] args) {
        Question680 q = new Question680();
        System.out.println(q.validPalindrome("abc"));
    }


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
}
