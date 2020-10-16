public class Question125 {


    public static void main(String[] args) {
        Question125 q = new Question125();
        long start = System.currentTimeMillis();
        System.out.println(q.isPalindromeRight("A man, a plan, a canal: Panama"));
        System.out.println(System.currentTimeMillis() - start + "ms");
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

    public boolean isPalindrome(String s) {
        StringBuilder original = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)){
                original.append(Character.toLowerCase(c));
            }
        }
        return new StringBuilder(original).reverse().toString().equals(original.toString());
    }

}
