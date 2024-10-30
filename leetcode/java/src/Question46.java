

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Question46 {


    public static void main(String[] args) {
        Question46 q = new Question46();
        int[] nums = {
                1,2,3,4
        };
        long start = System.currentTimeMillis();
        System.out.println(q.permute(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        help(nums, new ArrayDeque<>(),new boolean[nums.length], res);

        return res;
    }

    private void help(int[] nums, Deque<Integer> stack,boolean[] idx, List<List<Integer>> res) {
        for (int i = 0; i < nums.length; i++) {
            if (!idx[i]){
                idx[i] = true;
                int num = nums[i];
                stack.push(num);
                if (stack.size() == nums.length) {
                    res.add(new ArrayList<>(stack));
                }
                help(nums, stack,idx, res);
                stack.pop();
                idx[i] = false;
            }

        }
    }
}
