public class Question55 {
    public static void main(String[] args) {
        Question55 q = new Question55();
        int[] nums = {2, 3, 1, 1, 4};
        long start = System.currentTimeMillis();
        System.out.println(q.canJump(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public boolean canJump(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        flag[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                if (i + nums[i] >= nums.length - 1) {
                    return true;
                }
                for (int j = i + 1; j <= i + nums[i]; j++) {
                    flag[j] = true;
                }
            }
        }
        return flag[nums.length - 1];
    }

    public boolean canJumpI(int[] nums) {
        int far = 0;
        for (int i = 0; i < nums.length; i++) {
            if (far < i) {
                return false;
            }
            far = Math.max(far, i + nums[i]);
        }
        return true;
    }

}
