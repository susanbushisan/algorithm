import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question39 {
    public static void main(String[] args) {
        Question39 q12 = new Question39();
        int[] candidates = {
                2, 3, 6, 7
        };
        long start = System.currentTimeMillis();
        System.out.println(q12.combinationSum(candidates, 7));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        helper(candidates, target, stack, ans);
        return ans;
    }

    private void helper(int[] candidates, int target, LinkedList<Integer> stack, List<List<Integer>> ans) {
        for (int i = 0; i < candidates.length; i++) {
            int candidate = candidates[i];
            stack.push(candidate);
            if (candidate == target) {
                ans.add(new ArrayList<>(stack));
            } else if (candidate < target) {
                int[] arr = new int[candidates.length - i];
                System.arraycopy(candidates, i, arr, 0, arr.length);
                helper(arr, target - candidate, stack, ans);
            }
            stack.pop();
        }
    }
}
