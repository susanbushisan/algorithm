import java.util.Arrays;

public class Question396 {
    public static void main(String[] args) {
        Question396 q = new Question396();
        int[] nums = {4, 3, 2, 6};
        long start = System.currentTimeMillis();
        System.out.println(q.maxRotateFunction(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int maxRotateFunction(int[] nums) {
        int length = nums.length;
        int sum = 0;
        int numsCount = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i] * i;
            numsCount += nums[i];
        }
        int max = sum;
        for (int i = 1; i < length; i++) {
            sum = sum + numsCount - length * nums[length - i];
            max = Math.max(sum, max);
        }

        return max;
    }

}
