其实就是两个字符串的比较，只是多出一个处理退格，可以用栈处理，如果为'#'的话就出栈，空栈的话不做处理，如果不是就入栈，最后两个栈元素进行比较就可以了。

### 方法一：栈

~~~
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack<Character>();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
~~~

时间复杂度O(M+N),M和N是S.length和T.length
空间复杂度O(M+N)
