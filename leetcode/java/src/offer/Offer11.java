package offer;

/**
 * <a href="https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/?favorite=xb9nqhhg">剑指 Offer 03. 数组中重复的数字</a>
 */
public class Offer11 {
    public static void main(String[] args) {
        Offer11 o = new Offer11();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(o.minArray(nums));
    }

    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
