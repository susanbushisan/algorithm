import java.util.HashMap;

public class Question560 {

    public static void main(String[] args) {
        Question560 q = new Question560();
        int[] nums = {1, 2, 3};
        long start = System.currentTimeMillis();
        System.out.println(q.subarraySum(nums, 3));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}

