import java.util.ArrayDeque;
import java.util.Deque;

public class Question155 {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        long start = System.currentTimeMillis();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());


        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    static class MinStack {

        Deque<Integer> stack;

        Deque<Integer> assist;

        public MinStack() {
            stack = new ArrayDeque<>();
            assist = new ArrayDeque<>();
        }

        public void push(int val) {
            stack.push(val);
            if (assist.isEmpty() || assist.peek() > val) {
                assist.push(val);
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

        public int getMin() {
            return assist.peek();
        }
    }

}
