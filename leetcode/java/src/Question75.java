import java.util.*;

public class Question75 {
    public static void main(String[] args) {
        Question75 q = new Question75();
        int[] nums = {1, 2, 0,1,2,2,0};
        long start = System.currentTimeMillis();
        q.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public void sortColors(int[] nums) {
        int c1 = 0, c2 = 0;
        for (int num : nums) {
            if (num == 0) {
                c1++;
            } else if (num == 1) {
                c2++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < c1){
                nums[i] = 0;
            }else if (i < c1 + c2){
                nums[i] = 1;
            }else {
                nums[i] = 2;
            }
        }
    }
}
