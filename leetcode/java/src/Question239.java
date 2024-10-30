import java.util.*;

public class Question239 {
    public static void main(String[] args) {
        Question239 q = new Question239();
        int[] nums = {1, -1};
        long start = System.currentTimeMillis();
        int[] ints = q.maxSlidingWindow(nums, 1);
        // 1,7,5,6,3,4
        System.out.println(Arrays.toString(ints));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i < k - 1) {
                continue;
            }
            while (deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }

}
