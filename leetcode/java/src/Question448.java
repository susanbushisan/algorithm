import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question448 {

    public static void main(String[] args) {
        Question448 q = new Question448();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        long start = System.currentTimeMillis();
        System.out.println(q.findDisappearedNumbers(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }


}

