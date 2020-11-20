import java.util.*;

public class Question496 {
    public static void main(String[] args) {
        Question496 q = new Question496();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        long start = System.currentTimeMillis();

        System.out.println(Arrays.toString(q.nextGreaterElement(nums1, nums2)));

        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer,Integer> cache = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            cache.put(nums1[i], i);
        }
        stack.push(Integer.MAX_VALUE);
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        for (int value : nums2) {
            while (stack.peek() < value) {
                Integer pop = stack.pop();
                if (cache.containsKey(pop)){
                    ans[cache.get(pop)] = value;
                }
            }
            stack.push(value);
        }
        return ans;
    }
}
