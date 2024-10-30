package offer;

public class Offer56_1 {

    public int[] singleNumbers(int[] nums) {
        int r = 0;
        for (int num : nums) {
            r ^= num;
        }
        int bound = 1;
        while ((r & 1) == 0) {
            r = r >> 1;
            bound = bound << 1;
        }
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & bound) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}
