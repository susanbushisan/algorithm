package offer;

import java.util.PriorityQueue;
import java.util.Queue;

public class Offer41 {

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }


    static class MedianFinder {

        private Queue<Integer> max;
        private Queue<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            max = new PriorityQueue<>((o1, o2) -> o2 - o1);
            min = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (!min.isEmpty() && min.peek() < num) {
                min.offer(num);
                if (min.size() > max.size()) {
                    max.offer(min.poll());
                }
            } else {
                max.offer(num);
                if (max.size() == min.size() + 2) {
                    min.offer(max.poll());
                }
            }

        }

        public double findMedian() {
            if (max.size() != min.size()) {
                return max.peek();
            } else {
                return (max.peek() + min.peek()) / 2.0;
            }
        }
    }
}
