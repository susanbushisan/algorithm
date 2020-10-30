public class Question41 {
    public static void main(String[] args) {
        Question41 q = new Question41();
        int[] nums = {1,2,0};

        long start = System.currentTimeMillis();
        System.out.println(q.firstMissingPositive(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] < 1){
                nums[i] = length + 1;
            }
        }
        for (int i = 0; i < length; i++) {
            int x = Math.abs(nums[i]);
            if (x > 0 && x <= length){
                if (nums[x - 1] > 0){
                    nums[x - 1] = - nums[x - 1];
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0){
                return i + 1;
            }
        }
        return length + 1;
    }

}
