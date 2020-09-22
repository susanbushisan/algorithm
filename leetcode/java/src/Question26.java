import java.util.Arrays;


public class Question26 {
    public static void main(String[] args) {
        Question26 q26 = new Question26();
        long start = System.currentTimeMillis();
        int[] area = new int[]{1,1,2};
        System.out.println(q26.removeDuplicates(area));
        System.out.println(Arrays.toString(area));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]){
                nums[index] = nums[i];
                index ++;
            }
        }
        return index;
    }
}
