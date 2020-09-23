
import java.util.Arrays;


public class Question35 {

    public static void main(String[] args) {
        Question35 q35 = new Question35();
        int[] nums = {
                1, 3, 5, 6
        };
        int target = 0;
        long start = System.currentTimeMillis();
        System.out.println(q35.searchInsert(nums, target));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    /**
     * 哈哈哈
     */
    public int searchInsertJoke(int[] nums, int target) {
        int ans = Arrays.binarySearch(nums, target);
        return ans >= 0 ? ans : (-ans - 1);
    }

    /**
     * 二分搜索的变种，考验基本功的时候又到了
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (high >= low) {
            int mid = (high + low) >>> 1;
            int num = nums[mid];
            if (num == target) {
                return mid;
            }
            if (num < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

}