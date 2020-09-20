import java.util.*;

public class Question126 {
    public static void main(String[] args) throws Exception {
        Question126 q = new Question126();


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


    List<List<String>> res = new ArrayList<>();
    int length = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        // 如果不含有结束单词，直接结束，不然后边会造成死循环
        if (!wordList.contains(endWord)) {
            return ans;
        }
        bfs(beginWord, endWord, wordList, ans);
        return ans;
    }


    public void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> ans) {
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.offer(path);
        boolean isFound = false;
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int j = 0; j < size; j++) {
                List<String> p = queue.poll();
                //得到当前路径的末尾单词
                String temp = p.get(p.size() - 1);
                // 一次性得到所有的下一个的节点
                ArrayList<String> neighbors = getNeighbors(temp, dict);
                for (String neighbor : neighbors) {
                    //只考虑之前没有出现过的单词
                    if (!visited.contains(neighbor)) {
                        //到达结束单词
                        if (neighbor.equals(endWord)) {
                            isFound = true;
                            p.add(neighbor);
                            ans.add(new ArrayList<String>(p));
                            p.remove(p.size() - 1);
                        }
                        //加入当前单词
                        p.add(neighbor);
                        queue.offer(new ArrayList<String>(p));
                        p.remove(p.size() - 1);
                        subVisited.add(neighbor);
                    }
                }
            }
            visited.addAll(subVisited);
            if (isFound) {
                break;
            }
        }
    }


    /**
     * 使用回溯，还是超时，我要崩溃了，更好的方法是什么，基于深度优先的搜索超时，那么只能用广度优先搜索了
     */
    public List<List<String>> findLaddersErrors(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> stack = new LinkedList<>();
        for (Iterator<String> iterator = wordList.iterator(); iterator.hasNext(); ) {
            String word = iterator.next();
            if (word.equals(endWord)) {
                stack.add(word);
                if (same(beginWord, word)) {
                    stack.add(beginWord);
                    Collections.reverse(stack);
                    res.add(stack);
                    break;
                }
                iterator.remove();
                findBack(beginWord, word, stack, wordList);

            }
        }
        return res;
    }

    private void findBack(String beginWord, String endWord, LinkedList<String> stack, List<String> wordList) {
        List<String> next = getNext(endWord, new HashSet<>(wordList));
        for (String word : next) {

        }

        for (String word : wordList) {
            if (same(word, endWord)) {
                stack.push(word);
                if (same(word, beginWord)) {
                    LinkedList<String> sign = new LinkedList<>(stack);
                    sign.push(beginWord);
                    if (stack.size() < length) {
                        length = stack.size();
                        res.clear();
                    }
                    res.add(sign);
                }
                if (stack.size() < length) {
                    List<String> tempList = new ArrayList<>(wordList);
                    tempList.remove(word);
                    findBack(beginWord, word, stack, tempList);
                }
                stack.poll();
            }
        }
    }


    /**
     * 超时
     */
    @Deprecated
    public List<List<String>> findLaddersError(String beginWord, String endWord, List<String> wordList) {

        for (Iterator<String> iterator = wordList.iterator(); iterator.hasNext(); ) {
            String word = iterator.next();
            if (word.equals(endWord)) {
                List<String> temp = new ArrayList<>();
                temp.add(word);
                iterator.remove();
                find(beginWord, word, wordList, temp);
                break;
            }
        }

        return res;
    }

    private void find(String beginWord, String endWord, List<String> wordList, List<String> current) {

        wordList = new ArrayList<>(wordList);

        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (!same(word, endWord)) {
                continue;
            }
            List<String> currentTemp = new ArrayList<>(current);
            currentTemp.add(word);
            if (same(word, beginWord)) {
                if (current.size() >= length - 1) {
                    return;
                }
                if (!word.equals(beginWord)) {
                    currentTemp.add(beginWord);
                }
                if (currentTemp.size() < length) {
                    res.clear();
                }
                length = currentTemp.size();
                Collections.reverse(currentTemp);
                res.add(currentTemp);
            } else {
                List<String> temp = new ArrayList<>(wordList);
                temp.remove(i);
                find(beginWord, word, temp, currentTemp);
            }
        }

    }

    private boolean same(String a, String b) {
        boolean flag = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (!flag) {
                    flag = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    private ArrayList<String> getNeighbors(String cur, Set<String> dict){
        return getNext(cur,dict);
    }

    private ArrayList<String> getNext(String cur, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = cur.toCharArray();
        //考虑每一位
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            //考虑变成其他所有的字母
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) {
                    continue;
                }
                chars[i] = c;
                String next = new String(chars);
                //判断 wordList 是否包含修改后的单词
                if (dict.contains(next)) {
                    res.add(next);
                }
            }
            chars[i] = old;
        }
        return res;
    }

}
