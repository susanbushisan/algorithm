package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof">剑指 Offer 50. 第一个只出现一次的字符</a>
 */
public class Offer57_2 {
    public static void main(String[] args) {
        Offer57_2 o = new Offer57_2();
        System.out.println(Arrays.deepToString(o.findContinuousSequence(9)));
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int left = 1, right = 1, count = 0;

        while (left <= target / 2) {
            if (count == target) {
                int[] ints = new int[right - left];
                for (int i = left; i < right; i++) {
                    ints[i - left] = i;
                }
                res.add(ints);
            }
            if (count <= target) {
                count += right++;
            } else {
                count -= left++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
