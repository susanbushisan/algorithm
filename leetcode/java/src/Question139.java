import java.util.*;

public class Question139 {
    public static void main(String[] args) {
        Question139 q = new Question139();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaaaa");
        wordDict.add("aaaaaaaaaa");

        long start = System.currentTimeMillis();
        System.out.println(q.wordBreak(s,wordDict));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    Set<String> set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)){
            return true;
        }
        if(set.contains(s))
            return false;
        for (String word : wordDict) {
            if (s.startsWith(word) && wordBreak(s.substring(word.length()),wordDict)){
                return true;
            }
        }
        set.add(s);
        return false;
    }

}
