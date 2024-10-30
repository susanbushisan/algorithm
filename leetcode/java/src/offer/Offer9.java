package offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer9 {

    static class CQueue {

        private final Deque<Integer> in;
        private final Deque<Integer> out;

        public CQueue() {
            in = new ArrayDeque<>();
            out = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            in.push(value);
        }

        public int deleteHead() {
            if (out.isEmpty() && in.isEmpty()){
                return -1;
            }
            if (out.isEmpty()){
                while (!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            return out.pop();
        }
    }
}
