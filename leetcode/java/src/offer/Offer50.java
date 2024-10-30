package offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof">剑指 Offer 50. 第一个只出现一次的字符</a>
 */
public class Offer50 {
    public static void main(String[] args) {
        Offer50 o = new Offer50();
        System.out.println(o.firstUniqChar("leetcode"));
    }

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return ' ';
    }
}
