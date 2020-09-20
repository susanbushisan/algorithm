import java.util.*;

public class Question127 {
    public static void main(String[] args) throws Exception {
        Question127 q = new Question127();
        String a = "hot";
        String b = "dog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("cog");
        wordList.add("dog");
        wordList.add("tot");
        wordList.add("hog");
        wordList.add("hop");
        wordList.add("pot");
        wordList.add("dot");
        long start = System.currentTimeMillis();
        System.out.println(q.findLadders(a, b, wordList));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public int findLadders(String beginWord, String endWord, List<String> wordList) {
        return 0;
    }

}
