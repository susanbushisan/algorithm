
import java.util.*;

public class Question187 {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";//"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        Question187 q187 = new Question187();
        long start = System.currentTimeMillis();
        System.out.println(q187.findRepeatedDnaSequences(s));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if (len <10){
            return new ArrayList<>();
        }
        Set<String> result = new HashSet<>();
        Set<Integer> all = new HashSet<>();
        char[] map = new char[26];
        map[0] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int key = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < 10; i++) {
            key = key << 2 | map[array[i] - 'A'];
        }
        all.add(key);
        for (int i = 10; i < len; i++) {
            key <<= 2;
            key |= map[array[i] - 'A'];
            key &= 0xfffff;
            if (all.contains(key)) {
                result.add(s.substring(i - 9, i + 1));
            } else {
                all.add(key);
            }

        }
        return new ArrayList<>(result);
    }

}

