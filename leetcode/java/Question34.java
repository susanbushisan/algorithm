
import java.util.Arrays;

/**
 * Question34
 */
public class Question34 {

    public static void main(String[] args) {
        Question34 q20 = new Question34();
        int[] nums = {
            5,7,7,8,8,10
        };
        int target = 8;
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(q20.searchRange(nums, target)));
        System.out.println(System.currentTimeMillis() - start + "ms");
        
    }

    /**
     * 二分搜索，然后双向寻找
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if(index < 0){
            return new int[]{-1,-1};
        }
        int first = index;
        int last = index;
        while (true) {
            if (first == 0) {
                break;
            }
            if(nums[first] == nums[first - 1]){
                first --;
            }else{
                break;
            }
        }
        while (true) {
            if (last == nums.length-1) {
                break;
            }
            if(nums[last] == nums[last + 1]){
                last ++;
            }else{
                break;
            }
        }
        return new int[]{first,last};
    }

}