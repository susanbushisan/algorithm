public class Question581 {

    public static void main(String[] args) {
        Question581 q = new Question581();
        int[] nums = {1, 3, 5, 2, 4};
        long start = System.currentTimeMillis();
        System.out.println(q.findUnsortedSubarray(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

}

