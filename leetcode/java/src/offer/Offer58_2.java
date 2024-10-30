package offer;

/**
 * <a href="https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof">剑指 Offer 50. 第一个只出现一次的字符</a>
 */
public class Offer58_2 {
    public static void main(String[] args) {
        Offer58_2 o = new Offer58_2();
        System.out.println(o.reverseLeftWords("abcdefg", 2));
    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
