public class Question4 {
    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {2, 3, 4, 5, 6};
        Question4 q = new Question4();
        long start = System.currentTimeMillis();
        System.out.println(q.findMedianSortedArrays(nums1, nums2));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k = nums1.length + nums2.length;
        if (k % 2 == 1) {
            return minK(nums1, 0, nums2, 0, k / 2 + 1);
        }
        return (minK(nums1, 0, nums2, 0, k / 2 + 1) + minK(nums1, 0, nums2, 0, k / 2)) / 2;
    }

    double minK(int[] nums1, int left1, int[] nums2, int left2, int k) {
        int len1 = nums1.length - left1;
        int len2 = nums2.length - left2;
        if (len1 > len2) {
            return minK(nums2, left2, nums1, left1, k);
        }
        // 现在len1<len2
        if (len1 == 0) {
            return nums2[left2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }

        int i = left1 + Math.min(len1, k / 2) - 1;
        int j = left2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return minK(nums1, left1, nums2, j + 1, k - (j - left2 + 1));
        } else {
            return minK(nums1, i + 1, nums2, left2, k - (i - left1 + 1));
        }
    }

}

