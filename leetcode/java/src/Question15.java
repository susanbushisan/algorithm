
import java.util.*;

/**
 * 两数之和
 */
public class Question15 {
    public static void main(String[] args) {
        Question15 q = new Question15();
        int[] nums = new int[]{0,0,0};
        System.out.println(q.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    do {
                        right--;
                    } while (right >= i && nums[right] == nums[right + 1]);
                    do {
                        left++;
                    } while (left < nums.length - 1 && nums[left] == nums[left - 1]);
                } else if (nums[left] + nums[right] > target) {
                    do {
                        right--;
                    } while (right >= i && nums[right] == nums[right + 1]);
                } else {
                    do {
                        left++;
                    } while (left < nums.length - 1 && nums[left] == nums[left - 1]);
                }
            }
            do {
                i++;
            } while (i < nums.length - 2 && nums[i] == nums[i - 1]);
        }

        return res;
    }
}
