

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class Question152 {
    public static void main(String[] args) {
        Question152 q = new Question152();
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(q.maxProduct(nums));
        System.out.println(q.maxProductRight(nums));
    }

    /**
     * 从前到后再从后到前寻找最大连续乘积
     */
    private int maxProductRight(int[] nums) {
        int max = nums[0];
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            temp *= nums[i];
            max = Math.max(max,temp);
            if (nums[i] == 0){
                temp = 1;
            }
        }
        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            temp *= nums[i];
            max = Math.max(max,temp);
            if (nums[i] == 0){
                temp = 1;
            }
        }

        return max;
    }


    /**
     * 以每个数组坐标为起点向后寻找最大乘积
     */
    public int maxProduct(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int j = i; j  < nums.length; j++) {
                if (nums[j] == 0){
                    max = Math.max(max, 0);
                    break;
                }
                temp*=nums[j];
                if (temp > max){
                    max = temp;
                }
            }
        }
        return max;
    }

    /**
     * DP解法
     */
    public int maxProductDp(int[] nums) {
        int length = nums.length;
        int max = nums[0],min = nums[0],res = max;
        for (int i = 1; i < length; i++) {
            int mx = max,mn = min,current = nums[i];
            max = Math.max(mx * current,Math.max(current,current*mn));
            min = Math.min(mx * current,Math.min(current,current*mn));
            res = Math.max(max,res);
        }
        return res;
    }
}
