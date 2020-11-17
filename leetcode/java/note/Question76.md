可以把T变为key为char，value为count的map，然后判断字符串是否存在这样的子串，然后左右减去直到map不成立就可以算出最小覆盖子串了
前提是子串只有唯一解

数据校验了一下，不止唯一解，那么我暂时想到的只能是暴力找最小子串了,好的，暴力法诠释了什么是Time Limit Exceeded

正确解法应该是滑动窗口，主要是没想到，按照这个思路应该把题目解出来

使用两个哈希表，一个记录所需要的字符还需要多少，另一个记录当前滑动窗口中各字符的数量有多少，countcount记录滑动窗口中已经包含了tt中多少字符。


### 方法一：滑动窗口

开始左指针不动，右指针向右移动，直到窗口中包含了tt中全部字符，开始移动左指针收缩，收缩到窗口中刚好不满足tt中的字符为止。如此循环，一旦count == t.lengthcount==t.length说明当前是满足条件的，记录此时的大小和字符串。


~~~
    public String minWindow(String s, String t){
        int[] window = new int[128], need = new int[128];
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int count = 0, min = ss.length;
        String res = "";
        for (char value : tt) {
            need[value]++;
        }
        int i = 0, j = 0;
        while(j < ss.length) {
            char c = ss[j];
            window[c]++;
            if (window[c] <= need[c]){
                count++;
            }
            while(count == tt.length) {
                if (j - i + 1 < min){
                    res = s.substring(i, j + 1);
                    min = j - i + 1;
                }
                window[ss[i]]--;
                if (window[ss[i]] < need[ss[i]]){
                    count--;
                }
                i++;
                if (i >= ss.length){
                    break;
                }
            }
            j++;
        }
        return res;
    }
~~~
时间复杂度为O(N)，空间复杂度为O（1）