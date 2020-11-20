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

}
