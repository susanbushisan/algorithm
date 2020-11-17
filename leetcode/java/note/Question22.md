既然要生成集合，那么按照一定顺序遍历即可

###方法一：回溯
利用栈的先进先出，栈中数据左括号必须大于等于右括号，然后这是典项的回溯法，入栈元素是有限的左右括号

~~~
public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    Deque<Character> stack = new LinkedList<>();
    helper(stack,n,n,ans);
    return ans;
}

private void helper(Deque<Character> stack,int left,int right,List<String> ans){
    if (left > 0){
        stack.add('(');
        helper(stack,left - 1, right,ans);
        stack.removeLast();
    }
    if (right > 0 && right > left){
        stack.add(')');
        helper(stack,left, right - 1,ans);
        stack.removeLast();
    }else if (right == 0){
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        ans.add(sb.toString());
    }
}
~~~

代码实现：src/Question22.java  
时间复杂度为不太好算，考虑到回溯接近O（N），空间复杂度为O（N）


