import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两数之和
 */
public class Question16 {
    public static void main(String[] args) {
        Question16 q = new Question16();
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(q.threeSumClosest(nums, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1,right = nums.length -1;
            while (left < right){
                int threeSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(threeSum -target) < Math.abs(res -target)){
                    res = threeSum;
                }
                if (threeSum > target){
                    right--;
                }else {
                    left ++;
                }
            }

        }
        return res;
    }
}
