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
        System.out.println(q.wordBreak(s, wordDict));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    Set<String> set = new HashSet<>();

    public boolean wordBreakI(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        if (set.contains(s))
            return false;
        for (String word : wordDict) {
            if (s.startsWith(word) && wordBreakI(s.substring(word.length()), wordDict)) {
                return true;
            }
        }
        set.add(s);
        return false;
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0, new HashSet<>());
    }

    private boolean wordBreak(String s, List<String> wordDict, int index, Set<String> notExist) {
        if (index == s.length()) {
            return true;
        }
        String c = s.substring(index);
        if (notExist.contains(c)){
            return false;
        }
        for (String word : wordDict) {
            if (c.startsWith(word) && wordBreak(s, wordDict, index + word.length(), notExist)) {
                return true;
            }
        }
        notExist.add(c);
        return false;
    }

}
