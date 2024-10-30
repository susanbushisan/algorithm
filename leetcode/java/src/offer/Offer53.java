package offer;

/**
 * <a href="https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/?favorite=xb9nqhhg">剑指 Offer 03. 数组中重复的数字</a>
 */
public class Offer53 {
    public static void main(String[] args) {
        Offer53 o = new Offer53();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(o.search(new int[]{5, 7, 7, 8, 8, 10}, 7));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int leftStar = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid -1] != target) {
                    leftStar = mid;
                    break;
                }else {
                    right = mid - 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (leftStar == -1){
            return 0;
        }else {
            int count = 0;
            while (leftStar < nums.length && nums[leftStar] == target){
                count++;
                leftStar ++;
            }
            return count;
        }

    }
}
