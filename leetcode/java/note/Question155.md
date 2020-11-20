### 方法一：辅助栈

~~~
     static class MinStack {

        Deque<Integer> stack;
        Deque<Integer> assist;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new ArrayDeque<>();
            assist = new ArrayDeque<>();
        }
        public void push(int x) {
            stack.push(x);
            if (assist.isEmpty()){
                assist.push(x);
            }else if (x > assist.peek()){
                assist.push(assist.peek());
            }else {
                assist.push(x);
            }
        }
        public void pop() {
            stack.pop();
            assist.pop();
        }
        public int top() {
            return stack.peek();
        }
        public int getMin() {
            return assist.peek();
        }
    }
~~~

时间复杂度为O(1)，空间复杂度为O（N）

