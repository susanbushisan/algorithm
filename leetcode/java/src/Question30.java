import java.util.*;

public class Question30 {
    public static void main(String[] args) {
        Question30 q = new Question30();
        String[] words = {"word","good","best","good"};

        long start = System.currentTimeMillis();
        System.out.println(q.findSubstring("wordgoodgoodgoodbestword",words));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int length = words[0].length();
        if (length == 0 || length * words.length > s.length()){
            return res;
        }
        Map<String,Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.merge(word, 1, Integer::sum);
        }

        for (int i = 0; i <= s.length() - words.length * length; i++) {
            Map<String,Integer> current = new HashMap<>();
            for (int j = 0; j < words.length; j++) {
                int start = i + j * length;
                String substring = s.substring(start, start + length);
                if (wordMap.get(substring) == null){
                    break;
                }
                current.merge(substring, 1, Integer::sum);
                if (current.get(substring) > wordMap.get(substring)){
                    break;
                }
                if (j == words.length - 1){
                    res.add(i);
                }
            }
        }
        return res;
    }

}
