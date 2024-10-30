package offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof">剑指 Offer 50. 第一个只出现一次的字符</a>
 */
public class Offer58_1 {
    public static void main(String[] args) {
        Offer58_1 o = new Offer58_1();
        System.out.println(o.reverseWords(" the sky is blue "));
    }

    public String reverseWords(String s) {
        int c = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (c == -1 && s.charAt(i) != ' ') {
                c = i;
            } else if (c != -1 && s.charAt(i) == ' ') {
                if (sb.length() != 0){
                    sb.append(' ');
                }
                sb.append(s, i + 1, c + 1);
                c = -1;
            }
        }
        if (c != -1) {
            if (sb.length() != 0){
                sb.append(' ');
            }
            sb.append(s, 0, c + 1);
        }
        return sb.toString();
    }
}
