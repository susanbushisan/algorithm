package offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Offer48 {

    public static void main(String[] args) {
        Offer48 o = new Offer48();
        System.out.println(o.lengthOfLongestSubstring("aabaab!bb"));

    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (set.contains(c)) {
                while (s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            set.add(c);
            max = Math.max(max, set.size());
            right++;
        }
        max = Math.max(max, set.size());
        return max;
    }
}
