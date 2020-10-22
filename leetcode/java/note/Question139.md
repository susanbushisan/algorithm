一开始想到了一个绝妙的想法
~~~
    public boolean wordBreak(String s, List<String> wordDict) {
        outter:while (s.length() > 0){
            for (String word : wordDict) {
                if (s.startsWith(word)){
                    s = s.substring(word.length());
                    continue outter;
                }
            }
            return false;
        }
        return true;
    }
~~~

但是不行


    "cars"
    ["car","ca","rs"]

这个用例没通过，既然可能重复，看是只好上回溯法了，老规矩，递归和迭代都应该可以，但是我喜欢写递归

然后递归超时了？？？

    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
    ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
    
这么看到，极端数据确实不能通过。
一般超时优化的思路有三个
- 上Hash做缓存
- 剪枝排除极端数据，贪心
- 优化思路的其它解法

目前情况对于第一种比较合适,将不能通过的数据存入到set中，如果再次出现就return false;

代码实现：src/Question139.java

时间复杂度为O(n^2)，空间复杂度为O(n^2)