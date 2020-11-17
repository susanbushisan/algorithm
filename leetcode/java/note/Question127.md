经过之前有一道找最短路径的题目，可以知道这个题目应该使用广度优先搜索去解，搜索的层数就是返回的最短路劲
### 方法一：广度优先搜索

~~~
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
~~~

具体实现 src/Question127.java

