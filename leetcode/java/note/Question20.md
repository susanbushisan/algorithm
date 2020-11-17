思考

    括号都是一一对应的，可以用栈的特性完成这个需求，当我匹配到括号的左半边之后，将该括号的右半边入栈，当匹配到右半边括号的时候和栈顶元素相比较，如果一样则出栈，如果不一样就return false，当字符遍历完之后，只有栈为空栈才代表这是有效的符号

### 方法一：栈

利用栈的先进后出的特性，左半边括号入栈，右半边括号出栈，如果遍历过程中栈顶元素和对比元素不同代表匹配不上，如果遍历完成后不是空栈代表匹配不上
~~~
public boolean isValid(String s) {
    String left = "({[";
    String right = ")}]";
    Deque<Character> res = new LinkedList<>();
    for (char c : s.toCharArray()) {
        if (left.indexOf(c)!=-1){
            res.add(c);
        }else {
            if (res.size() > 0 && left.charAt(right.indexOf(c)) == res.getLast()){
                res.pollLast();
            }else {
                return false;
            }
        }
    }
    return res.size() == 0;
}
~~~

具体实现:/src/Question20.java



分析：
时间复杂度为O(n),
空间复杂度为O(n+∣Σ∣) Σ代表括号数*2，