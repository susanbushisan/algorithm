
import struct.TreeNode;

import java.util.*;


public class Question647 {
    public static void main(String[] args) {
        Question647 q = new Question647();
        long start = System.currentTimeMillis();
        System.out.println(q.countSubstrings("abc"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }

}
