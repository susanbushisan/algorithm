public class Question136 {
    public static void main(String[] args) {
        Question136 q = new Question136();
        int[] nums = {1, 0, 1, 3, 3, 0, 7};

        long start = System.currentTimeMillis();
        System.out.println(q.singleNumber(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

}
