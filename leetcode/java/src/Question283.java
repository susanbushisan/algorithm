

import java.util.Arrays;


public class Question283 {

    public static void main(String[] args) {
        Question283 q = new Question283();
        int[] asteroids = {0, 1, 0, 3, 12};
        long start = System.currentTimeMillis();
        q.moveZeroes(asteroids);
        System.out.println(System.currentTimeMillis() - start + "ms");
        System.out.print(Arrays.toString(asteroids));
    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}