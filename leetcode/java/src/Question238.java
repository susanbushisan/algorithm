import java.util.Arrays;

public class Question238 {
    public static void main(String[] args) {
        Question238 q = new Question238();
        int[] nums = {1,2,3,4};
        long start = System.currentTimeMillis();
        int[] ints = q.productExceptSelf(nums);
        // 1,7,5,6,3,4
        System.out.println(Arrays.toString(ints));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[nums.length - i - 1] = right[nums.length - i] * nums[nums.length - i];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

}
