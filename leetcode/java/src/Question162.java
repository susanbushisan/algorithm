public class Question162 {
    public static void main(String[] args) {
        Question162 question162 = new Question162();
        int[] array = {1, 2};
        long start = System.currentTimeMillis();
        System.out.println(question162.findPeakElementBinarySearch(array));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int findPeakElement(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i - 1;
            }
        }
        return nums.length - 1;
    }

    public int findPeakElementBinarySearch(int[] nums) {
        int left = 0,right = nums.length-1;
        while (left < right){
            int mid = (left + right)/2;
            if (nums[mid] > nums[mid + 1]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

}
