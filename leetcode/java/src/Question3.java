import java.util.HashSet;
import java.util.Set;

/**
 * 寻找最大连续字符不相同字串长度
 */
public class Question3 {
    public static void main(String[] args) {
        Question3 q = new Question3();
        long start = System.currentTimeMillis();
        System.out.println(q.lengthOfLongestSubstring("pwwkew"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 官方解答，原理为滚动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        boolean[] flag = new boolean[128];
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                flag[s.charAt(i - 1)] = false;
            }
            while (right + 1 < s.length() && !flag[s.charAt(right + 1)]) {
                flag[s.charAt(right + 1)] = true;
                right++;
            }
            max = Math.max(max, right - i + 1);
        }
        return max;
    }

    /**
     * 暴力解法
     */
    public int lengthOfLongestSubstringV(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> contain = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (contain.contains(c)){
                    break;
                }else {
                    contain.add(c);
                }
            }
            res = Math.max(res,contain.size());
        }
        return res;
    }
}
