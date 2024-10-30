package offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer30 {

    class MinStack {

        private Deque<Integer> stack;

        private Deque<Integer> assist;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new ArrayDeque<>();
            assist = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.push(x);
            if (assist.isEmpty() || assist.peek() >= x) {
                assist.push(x);
            } else {
                assist.push(assist.peek());
            }
        }

        public void pop() {
            stack.pop();
            assist.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return assist.peek();
        }
    }
}
