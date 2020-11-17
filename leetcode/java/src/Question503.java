
import java.util.*;

public class Question503 {

    public static void main(String[] args) {
        Question503 q = new Question503();
        int[] arr = {
                1,2,3,4,3
        };
        System.out.println("before: " + Arrays.toString(arr));
        long start = System.currentTimeMillis();
        System.out.println("after: " + Arrays.toString(q.nextGreaterElements(arr)));
        System.out.println(System.currentTimeMillis() - start + "ms");
        start = System.currentTimeMillis();
        System.out.println("after: " + Arrays.toString(q.nextGreaterElements2(arr)));
        System.out.println(System.currentTimeMillis() - start + "ms");

        start = System.currentTimeMillis();
        System.out.println("after: " + Arrays.toString(q.nextGreaterElements3(arr)));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                int index = i + j >= nums.length ? i + j - nums.length : i + j;
                if (nums[i] < nums[index]) {
                    result[i] = nums[index];
                    break;
                }
                if (j == result.length - 1) {
                    result[i] = -1;
                }
            }
        }
        return result;
    }

    public int[] nextGreaterElements2(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    public int[] nextGreaterElements3(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length * 2 - 1; i ++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                res[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return res;
    }

}
