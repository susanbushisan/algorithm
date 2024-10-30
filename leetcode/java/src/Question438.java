import java.util.*;

public class Question438 {
    public static void main(String[] args) {
        Question438 q = new Question438();
        long start = System.currentTimeMillis();
        System.out.println(q.findAnagrams("abab", "ab"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                map.put(c, -1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int times = map.getOrDefault(c, 0) + 1;
            if (times == 0) {
                map.remove(c);
            } else {
                map.put(c, times);
            }
            if (i >= p.length()) {
                char out = s.charAt(i - p.length());
                times = map.getOrDefault(out, 0) - 1;
                if (times == 0) {
                    map.remove(out);
                } else {
                    map.put(out, times);
                }
            }
            if (map.isEmpty()) {
                res.add(i - p.length()+1);
            }
        }
        return res;
    }
}
