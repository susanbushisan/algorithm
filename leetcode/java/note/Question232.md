### 方法一：双栈合并

核心思想为：入队的时往栈A中入栈，出栈时用栈B出栈，如果栈B为空，将栈A所有元素出栈，将这些元素入栈到栈B
~~~
    static class MyQueue {

        Deque<Integer> stackA = new ArrayDeque<>();
        Deque<Integer> stackB = new ArrayDeque<>();


        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
           stackA.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (stackB.isEmpty()){
                while (!stackA.isEmpty()){
                    stackB.push(stackA.pop());
                }
            }
            return stackB.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (stackB.isEmpty()){
                while (!stackA.isEmpty()){
                    stackB.push(stackA.pop());
                }
            }
            return stackB.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stackA.isEmpty() && stackB.isEmpty();
        }
    }
~~~

复杂度分析
- 入栈的时间复杂度为O（1），出栈的时间复杂度最好为O（1）,最坏为O（N），均摊为O(1)