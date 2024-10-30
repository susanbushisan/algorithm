
import java.util.Arrays;

/**
 * Question34
 */
public class Question34 {

    public static void main(String[] args) {
        Question34 q20 = new Question34();
        int[] nums = {
                5, 7, 7, 8, 8, 10
        };
        int target = 8;
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(q20.searchRange(nums, target)));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    /**
     * 二分搜索，然后双向寻找
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRangeI(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return new int[]{-1, -1};
        }
        int first = index;
        int last = index;
        while (true) {
            if (first == 0) {
                break;
            }
            if (nums[first] == nums[first - 1]) {
                first--;
            } else {
                break;
            }
        }
        while (true) {
            if (last == nums.length - 1) {
                break;
            }
            if (nums[last] == nums[last + 1]) {
                last++;
            } else {
                break;
            }
        }
        return new int[]{first, last};
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (index == -1) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];

        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target){
                if (mid == 0 || nums[mid - 1] != target){
                    index = mid;
                    break;
                }else {
                    right = mid - 1;
                }
            }else
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        res[0] = index;

        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target){
                if (mid == nums.length -1 || nums[mid + 1] != target){
                    index = mid;
                    break;
                }else {
                    left = mid + 1;
                }
            }else
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        res[1] = index;


        return res;
    }

}