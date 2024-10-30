import util.TimerUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Question347 {
    public static void main(String[] args) {
        Question347 q = new Question347();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(TimerUtils.op(() -> q.topKFrequent(nums, 2))));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(k, (e1, e2) -> e1.getValue() - e2.getValue());
        int i = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            i ++;
            heap.add(integerIntegerEntry);
            if (i > k) {
                heap.remove();
            }
        }
        int[] res = new int[k];
        for (int j = 0; j < k; j++) {
            res[j] = heap.poll().getKey();
        }
        return res;
    }

}
