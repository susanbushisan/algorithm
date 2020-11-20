import java.util.ArrayDeque;
import java.util.Deque;

public class Question232 {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());

    }

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


}
