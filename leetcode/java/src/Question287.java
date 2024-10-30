

import java.util.Arrays;


public class Question287 {

    public static void main(String[] args) {
        Question287 q = new Question287();
        int[] nums = {1, 3, 4, 2, 2};
        long start = System.currentTimeMillis();
        System.out.println(q.findDuplicate(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            // nums 中小于等于 mid 的元素的个数
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                // 下一轮搜索的区间 [left..mid]
                right = mid;
            } else {
                // 下一轮搜索的区间 [mid + 1..right]
                left = mid + 1;
            }
        }
        return left;
    }

}