这题一看就挺花时间的，因为要判断位置不同字符相同的str。

那么可以排序字符生成排序字符串，并以它做key，如果没出息在map中就添加一个list，如果存在就在list中add原字符串
### 方法一：排序字符串

~~~
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> center = new HashMap<>();

        for (String str : strs) {
            String dictStr = transDictString(str);
            if (center.get(dictStr) == null){
                List<String> hashSet = new ArrayList<>();
                hashSet.add(str);
                center.put(dictStr,hashSet);
            }else {
                center.get(dictStr).add(str);
            }
        }

        return new ArrayList<>(center.values());
    }

    private String transDictString(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
~~~

代码实现：src/Question49.java

时间复杂度：O(NKlogK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。当我们遍历每个字符串时，外部循环具有的复杂度为 O(N)。然后，我们在 O(KlogK) 的时间内对每个字符串排序。  
空间复杂度：O(NK)，排序存储在 ans 中的全部信息内容。
