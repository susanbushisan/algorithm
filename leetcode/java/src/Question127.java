import java.util.*;

public class Question127 {
    public static void main(String[] args) throws Exception {
        Question127 q = new Question127();
        String a = "hit";
        String b = "cog";
//        List<String> wordList = new ArrayList<>();
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
//        wordList.add("hot");
//        wordList.add("cog");
//        wordList.add("dog");
//        wordList.add("tot");
//        wordList.add("hog");
//        wordList.add("hop");
//        wordList.add("pot");
//        wordList.add("dot");
        long start = System.currentTimeMillis();
        System.out.println(q.ladderLength(a, b, wordList));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        int step = 1;
        if (dict.size() == 0 || !dict.contains(endWord)) {
            return 0;
        }
        wordList.remove(beginWord);

        Set<String> visited = new HashSet<>();
        Deque<String> current = new LinkedList<>();
        visited.add(beginWord);
        current.add(beginWord);


        while (!current.isEmpty()){
            int size = current.size();
            for (int i = 0; i < size; i++) {
                String poll = current.poll();
                visited.add(poll);
                ArrayList<String> neighbors = getNeighbors(poll, dict,visited);
                for (String x : neighbors) {
                    if (x.equals(endWord)){
                        return step + 1;
                    }
                    if (!visited.contains(x)){
                        current.add(x);
                    }
                }
            }
            step ++;
        }
        return 0;
    }

    private ArrayList<String> getNeighbors(String node, Set<String> dict, Set<String> visited) {
        ArrayList<String> res = new ArrayList<>();
        char[] chs = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch)
                    continue;
                char old_ch = chs[i];
                chs[i] = ch;
                String str = String.valueOf(chs);
                if (dict.contains(str)&& !visited.contains(str)) {
                    res.add(str);
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

}
