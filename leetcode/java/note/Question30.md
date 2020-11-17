看到这道题没啥思路，唯一想到的就是暴力法，将所有单词拼到一起，然后寻找每个的可能起始位置  
如果数据量大的话暴力做法基本上是要超时的

既然超时，就考虑上map，既然题目确定了字符串的长度，那么可以将每个截取的字符串存到map中，以字符串为key
已出现的次数为value，然后和题目给出的单词转换出来的字典比较

### 方法一：哈希表

已word为key，已出现次数为val，出现就次数-1，当全部单词都出现后就找到正确答案了

~~~
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
~~~
假设 s 的长度是 n，words 里有 m 个单词

分析：  
时间复杂度为O(n * m)  
空间复杂度为O（m）  