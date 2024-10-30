
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最大连续乘积
 */
public class Question169 {


    public static void main(String[] args) {
        Question169 q = new Question169();
        int[] height = {
                2,3,2,4
        };
        long start = System.currentTimeMillis();
        System.out.println(q.majorityElement(height));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 统计出现的次数，然后返回次数最多的
     */
    public int majorityElementI(int[] nums) {
        Map<Integer,Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.merge(num,1, Integer::sum);
        }
        int maxCount = 0,v = nums[0];
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > maxCount){
                maxCount = entry.getValue();
                v = entry.getKey();
            }
        }
        return v;
    }

    public int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElementVote(int[] nums) {
        int voter = nums[0];
        int ticket = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (voter == num){
                ticket ++;
            }else {
                ticket --;
                if (ticket == 0){
                    voter = num;
                    ticket = 1;
                }
            }
        }
        return voter;
    }

























    public int majorityElement(int[] nums) {
        int vote = nums[0];
        int ticket = 0;
        for (int num : nums) {
            if (vote == num){
                ticket ++;
            }else {
                if (ticket == 0){
                    vote = num;
                    ticket = 1;
                }else {
                    ticket --;
                }
            }
        }
        return vote;
    }
}
