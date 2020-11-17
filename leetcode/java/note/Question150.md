思考

    题目告诉你思路了，适合用栈操作运算，那就是遇到符号了出栈2个，然后计算 第一个 运算符 第二个
    
### 方法一：栈
~~~
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int var1 = stack.pop();
                    int var2 = stack.pop();
                    stack.push(var1 + var2);
                    break;
                }
                case "-": {
                    int var1 = stack.pop();
                    int var2 = stack.pop();
                    stack.push(var2 - var1);
                    break;
                }
                case "*": {
                    int var1 = stack.pop();
                    int var2 = stack.pop();
                    stack.push(var1 * var2);
                    break;
                }
                case "/": {
                    int var1 = stack.pop();
                    int var2 = stack.pop();
                    stack.push(var2 / var1);
                    break;
                }
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }
~~~
    
代码实现： src/Question150.java

时间复杂度和空间复杂度都为O(N)