

/**
 * 扰乱字符串,给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 * 测试数据包含三个条件:
 * s1.length() == s2.length()
 * 1<length<30
 * s1和s2只包含小写字符
 */
public class Question87 {
    public static void main(String[] args) {
        Question87 q = new Question87();
        String a = "abcdefghijklmnopq";
        String b = "efghijklmnopqcadb";

        long start = System.currentTimeMillis();
        System.out.println(q.isScramble(a, b));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 思路，递归，每个字符串可以分隔为两个非空字符串，如果存在的两个字串都是扰乱字符串，则这个字符串是干扰字符串
     *
     * 判断字符数量是否相等防止递归超时
     */

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
}
