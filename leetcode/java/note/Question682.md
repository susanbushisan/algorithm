### 方法一：栈

典型的栈的栈的应用，用它找到前一个数

~~~
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : ops) {
            if (op.equals("+")){
                int pop = stack.pop();
                int n = pop + stack.peek();
                stack.push(pop);
                stack.push(n);
            }else if (op.equals("C")){
                stack.pop();
            }else if (op.equals("D")){
                stack.push(stack.peek() *2);
            }else {
                stack.push(Integer.parseInt(op));
            }
        }
        int ans = 0;
        for (Integer integer : stack) {
            ans += integer;
        }
        return ans;
    }
~~~

时间复杂度O(N)
空间复杂度O(1)