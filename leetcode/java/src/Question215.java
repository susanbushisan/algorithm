import java.util.*;

public class Question215 {
    public static void main(String[] args) {
        Question215 q = new Question215();
        int[] nums = {3, 2, 1, 5, 6, 4};
        long start = System.currentTimeMillis();
        System.out.println(q.findKthLargest(nums, 2));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(o -> o));
        for (int i = 0; i < nums.length; i++) {
            if (i < k){
                heap.add(nums[i]);
                continue;
            }
            if (heap.peek() < nums[i]){
                heap.poll();
                heap.add(nums[i]);
            }

        }
        return heap.peek();
    }
}
