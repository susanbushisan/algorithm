import java.util.HashMap;
import java.util.Map;

public class Question76 {
    public static void main(String[] args) {
        Question76 q = new Question76();
        String a = "ab";
        String b = "b";

        long start = System.currentTimeMillis();
        System.out.println(q.minWindow(a, b));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public String minWindowI(String s, String t) {
        int[] window = new int[128], need = new int[128];
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int count = 0, min = ss.length;
        String res = "";
        for (char value : tt) {
            need[value]++;
        }
        int i = 0, j = 0;
        while (j < ss.length) {
            char c = ss[j];
            window[c]++;
            if (window[c] <= need[c]) {
                count++;
            }
            while (count == tt.length) {
                if (j - i + 1 < min) {
                    res = s.substring(i, j + 1);
                    min = j - i + 1;
                }
                window[ss[i]]--;
                if (window[ss[i]] < need[ss[i]]) {
                    count--;
                }
                i++;
                if (i >= ss.length) {
                    break;
                }
            }
            j++;
        }
        return res;
    }


    public String minWindowViolent(String s, String t) {
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : t.toCharArray()) {
            dict.merge(c, 1, Integer::sum);
        }
        Map<Character, Integer> calc = new HashMap<>();
        for (char c : s.toCharArray()) {
            calc.merge(c, 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> entry : dict.entrySet()) {
            Character key = entry.getKey();
            if (calc.getOrDefault(key, 0) < entry.getValue()) {
                return "";
            }
        }
        String min = s;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dict.get(c) == null) {
                continue;
            }
            Map<Character, Integer> current = new HashMap<>(calc);
            for (int j = s.length() - 1; j >= i; j--) {
                char e = s.charAt(j);
                if (dict.get(e) != null && current.get(e) - 1 < dict.get(e)) {
                    String cMin = s.substring(i, j + 1);
                    if (cMin.length() < min.length()) {
                        min = cMin;
                    }
                    break;
                } else {
                    current.merge(e, -1, Integer::sum);
                }
            }
            if (calc.get(c) - 1 < dict.get(c)) {
                break;
            }
            calc.merge(c, -1, Integer::sum);
        }
        return min;
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            int before = tMap.getOrDefault(c, 0);
            tMap.put(c, before + 1);
        }
        int left =0, right = 0;
        int rLeft = -1, rRight = -1;
        Map<Character, Integer> cMap = new HashMap<>();
        while (right < s.length()) {
            if (tMap.containsKey(s.charAt(right))) {
                cMap.put(s.charAt(right), cMap.getOrDefault(s.charAt(right), 0) + 1);
                if (judge(cMap, tMap)) {
                    if (rLeft == -1 || right - left < rRight - rLeft){
                        rLeft = left;
                        rRight = right;
                    }
                    while (left <= right) {
                        char c = s.charAt(left);
                        left ++;
                        if (tMap.containsKey(c)) {
                            if (right - left + 1 < rRight - rLeft){
                                rLeft = left - 1;
                                rRight = right;
                            }
                            cMap.put(c, cMap.get(c) - 1);
                            if (!judge(cMap, tMap)) {
                                break;
                            }
                        }
                    }
                }
            }
            right++;
        }

        return rLeft == -1?"": s.substring(rLeft,rRight + 1);
    }

    private boolean judge(Map<Character, Integer> cMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Character key = entry.getKey();
            if (!cMap.containsKey(key) || cMap.get(key) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

}
