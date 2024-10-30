import java.util.Arrays;


public class Question31 {
    public static void main(String[] args) {
        Question31 q = new Question31();
        long start = System.currentTimeMillis();
        int[] area = new int[]{1,3,2};
        q.nextPermutation(area);
        System.out.println(Arrays.toString(area));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
