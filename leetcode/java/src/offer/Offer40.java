package offer;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/ti-huan-kong-ge-lcof/">剑指 Offer 05. 替换空格</a>
 */
public class Offer40 {
    public static void main(String[] args) {
        Offer40 o = new Offer40();
        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        System.out.println(Arrays.toString(o.getLeastNumbers(arr, 8)));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        quick(arr, k, 0, arr.length);
        return Arrays.copyOf(arr, k);
    }

    private void quick(int[] arr, int k, int left, int right) {
        if (left >= right - 1) {
            return;
        }
        int partition = left;
        for (int j = left; j < right - 1; j++) {
            if (arr[j] <= arr[right - 1]) {
                swap(arr, partition, j);
                partition++;
            }
        }
        swap(arr, partition, right - 1);
        if (partition < k) {
            quick(arr, k, partition + 1, right);
        } else {
            quick(arr, k, left, partition);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
