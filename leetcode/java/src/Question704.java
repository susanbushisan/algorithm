public class Question704 {
    public static void main(String[] args) {
        Question704 q = new Question704();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        long start = System.currentTimeMillis();
        System.out.println(q.search(nums, 9));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
