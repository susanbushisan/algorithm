package offer;

public class Offer51 {

    public static void main(String[] args) {
        Offer51 o = new Offer51();
        System.out.println(o.reversePairs(new int[]{7, 5, 6, 4}));
    }

    public int reversePairs(int[] nums) {

        return mergeSort(nums, 0, nums.length);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        int i = mergeSort(nums, left, mid);
        int j = mergeSort(nums, mid, right);
        int k = merge(nums, left, right);
        return i + j + k;
    }

    private int merge(int[] nums, int left, int right) {
        int res = 0;
        int mid = left + ((right - left) >> 1);
        int[] temp = new int[right - left];
        int l = left, r = mid;
        for (int i = 0; i < temp.length; i++) {
            if (l == mid) {
                temp[i] = nums[r++];
            } else if (r == right) {
                temp[i] = nums[l++];
            } else {
                if (nums[l] <= nums[r]) {
                    temp[i] = nums[l++];
                } else {
                    temp[i] = nums[r++];
                    res += mid - l ;
                }
            }
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
        return res;
    }
}
