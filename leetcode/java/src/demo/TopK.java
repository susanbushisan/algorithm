package demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopK {
    public static void main(String[] args) {
        int[] arr = new int[]{3,123,432,132,3214,123,21321,312,3,213,123,112,43243};
        System.out.println(Arrays.toString(topk(arr, 3)));
    }

    /**
     * 时间复杂度为O(logN)
     * @param arr
     * @param i
     * @return
     */
    private static int[] topk(int[] arr, int i) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(i, Comparator.reverseOrder());
        for (int i1 : arr) {
            heap.offer(i1);
        }
        int[] res = new int[i];

        for (int j = 0; j < i; j++) {
            res[j] = heap.poll();
        }
        return res;
    }

}
