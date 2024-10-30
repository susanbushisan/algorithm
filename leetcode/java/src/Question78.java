import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Question78 {
    public static void main(String[] args) {
        Question78 q = new Question78();
        int[] nums = {1, 2, 3};
        long start = System.currentTimeMillis();
        System.out.println(q.subsets(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 一看就是DFS，暴力,我喜欢
     */
    public List<List<Integer>> subsetsI(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if (nums.length == 0) {
            return ans;
        }
        Deque<Integer> stack = new LinkedList<>();
        bfs(nums, 0, stack, ans);
        return ans;
    }

    private void bfs(int[] nums, int index, Deque<Integer> stack, List<List<Integer>> ans) {
        for (int i = index; i < nums.length; i++) {
            stack.push(nums[i]);
            ans.add(new ArrayList<>(stack));
            bfs(nums, i + 1, stack, ans);
            stack.pop();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        for (int i = 0; i < (1 << nums.length); i++) {
            sub.clear();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    sub.add(nums[j]);
                }
            }
            res.add(new ArrayList<>(sub));
        }
        return res;
    }
}
