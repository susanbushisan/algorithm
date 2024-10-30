import java.util.*;

public class Question49 {
    public static void main(String[] args) {
        Question49 q = new Question49();
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};

        long start = System.currentTimeMillis();
        System.out.println(q.groupAnagrams(str));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public List<List<String>> groupAnagramsI(String[] strs) {

        Map<String, List<String>> center = new HashMap<>();

        for (String str : strs) {
            String dictStr = transDictString(str);
            if (center.get(dictStr) == null) {
                List<String> hashSet = new ArrayList<>();
                hashSet.add(str);
                center.put(dictStr, hashSet);
            } else {
                center.get(dictStr).add(str);
            }
        }

        return new ArrayList<>(center.values());
    }

    private String transDictString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> center = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String dictStr = new String(chars);
            if (center.containsKey(dictStr)){
                center.get(dictStr).add(str);
            }else {
                List<String> entity = new ArrayList<>();
                entity.add(str);
                center.put(dictStr,entity);
            }
        }

        return new ArrayList<>(center.values());
    }

}
