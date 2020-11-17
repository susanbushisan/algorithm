思考

    可以先判断字典中有没有endWord，如果没有的话返回0，如果有的话反向推到beginWord,提到了最短，那么深度优先就可以了，很遗憾，超时了。换个思路，用回溯法
    
    还是超时，在大量数据是DFS很难行得通，需要BFS找到之后就不在继续寻找了
    
### 方法一：回溯法

~~~
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
~~~

### 方法二：BFS

~~~
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
~~~