思考

    最后答案需要一个长度，最简单的方法是遍历所有子串，然后判断他有没有重复字符，然后找出无重复字符的最长子串长度，
    还可以用滚动窗口来做，用两个下标表示子串的开始和结束，右边不断往后推动，如果新元素在已知元素中，那么把左边下
    标到已知的元素剪掉，即可一遍找到可能成为最大的不重复子串。

方法一：暴力法

~~~
res = 0;
for (int i = 0; i < s.length(); i++) {
    Set<Character> contain = new HashSet<>();
    for (int j = i; j < s.length(); j++) {
        char c = s.charAt(j);
        if (contain.contains(c)){
            break;
        }else {
            contain.add(c);
        }
    }
    res = Math.max(res,contain.size());
}
return res;
~~~

具体实现:/src/Question3.lengthOfLongestSubstringV

- 时间复杂度O（N^2）  
- 空间复杂度O (N^2)

方法一：滑动窗口

核心思想类似窗口一样，右指针向右达到临界状态，左指针向右，脱离临界状态
~~~
int max = 0;
boolean[] flag = new boolean[128];
int right = -1;
for (int i = 0; i < s.length(); i++) {
    if (i != 0) {
        flag[s.charAt(i - 1)] = false;
    }
    while (right + 1 < s.length() && !flag[s.charAt(right + 1)]) {
        flag[s.charAt(right + 1)] = true;
        right++;
    }
    max = Math.max(max, right - i + 1);
}
return max;
~~~


具体实现:/src/Question3.lengthOfLongestSubstring

- 时间复杂度O（N）  
- 空间复杂度O (1)