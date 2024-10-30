
public class Question5 {
    public static void main(String[] args) {
        Question5 q5 = new Question5();
        long start = System.currentTimeMillis();
        String s = "aba";
        System.out.println(q5.longestPalindrome(s));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public String longestPalindromeI(String s) {
        int start = 0;
        int len = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; ) {
            int[] res = expand(arr, i);
            i = res[2];
            if (len < res[1]) {
                len = res[1];
                start = res[0];
            }
        }
        return s.substring(start, start + len);
    }

    private int[] expand(char[] arr, int center) {
        int left = center;
        int right = center + 1;
        while (right < arr.length && arr[left] == arr[right]) {
            right++;
        }
        center = right;
        left--;
        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            left--;
            right++;
        }
        return new int[]{left + 1, right - left - 1, center};
    }

    public String longestPalindrome(String s) {
        int start = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] res = expand(s, i);
            i = res[2];
            if (len < res[1]) {
                len = res[1];
                start = res[0];
            }
        }

        return s.substring(start, start + len);
    }

    private int[] expand(String s, int center) {
        int left = center;
        int right = center + 1;
        while (right < s.length() && s.charAt(left) == s.charAt(right)) {
            right++;
        }
        center = center + (right - center) / 2;
        left--;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right - left - 1, center};
    }
}
