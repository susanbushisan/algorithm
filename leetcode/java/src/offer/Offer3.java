package offer;

/**
 * <a href="https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/?favorite=xb9nqhhg">剑指 Offer 03. 数组中重复的数字</a>
 */
public class Offer3 {
    public static void main(String[] args) {
        Offer3 o = new Offer3();
        int[] nums = {3, 4, 2, 1, 1, 0};
        System.out.println(o.findRepeatNumber(nums));
    }

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (nums[index] == i) {
                continue;
            }
            if (nums[index] == index) {
                return index;
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            i--;
        }
        return -1;
    }
}
