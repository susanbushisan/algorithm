package demo;

import java.util.*;


public class SortThree {


    /**
     * 桶排序
     * @param arr
     */
    public static void bucketSort(int[] arr) {
        int[][] bucket = new int[10][10];
        int[] index = new int[10];
        for (int i : arr) {
            int in = i / 10;
            bucket[in][index[in]] = i;
            index[in]++;
        }
        for (int i = 0; i < bucket.length; i++) {
            SortTwo.quickSort(bucket[i], index[i]);
        }
        int current = 0;
        for (int i = 0; i < 10; i++) {
            int[] ints = Arrays.copyOfRange(bucket[i], 0, index[i]);
            System.arraycopy(ints, 0, arr, current, index[i]);
            current += index[i];
        }
    }

    /**
     * 计数排序
     * @param arr
     */
    public static void countingSort(int[] arr) {
        int[][] bucket = new int[100][2];
        for (int i : arr) {
            bucket[i][0] = i;
            bucket[i][1] ++;
        }
        int current = 0;
        for (int i = 0; i < 100; i++) {
            if (bucket[i][1] > 0){
                Arrays.fill(arr,current, current + bucket[i][1],i);
                current += bucket[i][1];
            }
        }

    }

    /**
     * 基数排序
     * @param arr
     */
    public static void radixSort(int[] arr) {
        class T {
            int x;
            T(int x){
                this.x = x;
            }
        }
        List<T> list = new ArrayList<T>();
        for (int i : arr) {
            list.add(new T(i));
        }
        list.sort(Comparator.comparingInt(x -> x.x % 10));
        list.sort(Comparator.comparingInt(x -> x.x / 10));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i).x;
        }

    }


    public static void main(String[] args) {
        int[] arr = {13, 5, 7, 26, 33, 95, 50, 84, 23, 18};
        int[] clone = arr.clone();

        bucketSort(clone);
        System.out.println("after bubble sort :" + Arrays.toString(clone));

        clone = arr.clone();
        countingSort(clone);
        System.out.println("after insertion sort :" + Arrays.toString(clone));

        clone = arr.clone();
        radixSort(clone);
        System.out.println("after selection sort :" + Arrays.toString(clone));
    }
}
