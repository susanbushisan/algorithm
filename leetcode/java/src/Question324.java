import java.util.*;

public class Question324 {
    public static void main(String[] args) {
        Question324 q = new Question324();
        int[] nums = {1, 3, 2, 2, 3, 1};
        long start = System.currentTimeMillis();
        q.wiggleSort(nums);
        // 1,7,5,6,3,4
        System.out.println(Arrays.toString(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }

}
