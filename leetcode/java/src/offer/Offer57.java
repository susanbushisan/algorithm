package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof">剑指 Offer 50. 第一个只出现一次的字符</a>
 */
public class Offer57 {
    public static void main(String[] args) {
        Offer57 o = new Offer57();
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(o.twoSum(nums, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left= 0,right = nums.length -1;
        while (left < right){
            int c = nums[left] + nums[right];
            if (target == c){
                return new int[]{nums[left],nums[right]};
            }else if (target > c){
                left ++;
            }else {
                right --;
            }
        }
        return null;
    }
}
