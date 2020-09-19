
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class Question1 {
    public static void main(String[] args) {
        Question1 q = new Question1();
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(q.twoSum(nums, 9)));
        System.out.println(Arrays.toString(q.twoSumRight(nums, 9)));
    }

    /**
     * 个人方法，暴力寻找。时间复杂度为O（n^2）
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 大佬解法
     */
    public int[] twoSumRight(int[] nums, int target) {
        Map<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])){
                return new int[]{hash.get(nums[i]),i};
            }
            hash.put(target-nums[i],i);
        }
        return null;
    }
}
