import java.util.HashSet;
import java.util.Set;

public class Question128 {


    public static void main(String[] args) {
        Question128 q = new Question128();
        int[] nums = {1,4,8};
        long start = System.currentTimeMillis();
        System.out.println(q.longestConsecutive(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for (Integer integer : set) {
            if (set.contains(integer - 1)) {
                continue;
            }
            int count = 0;
            while (set.contains(integer + count)) {
                count++;
            }
            longestStreak = Math.max(longestStreak, count);
        }

        return longestStreak;
    }

}
