import java.util.Comparator;
import java.util.PriorityQueue;

public class Question217 {
    public static void main(String[] args) {
        Question217 q = new Question217();
        int[] nums = {3, 2, 1, 5, 6, 4};
        long start = System.currentTimeMillis();
        System.out.println(q.containsDuplicate(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public boolean containsDuplicate(int[] nums) {
        return false;
    }
}
