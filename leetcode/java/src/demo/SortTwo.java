package demo;

import java.util.Arrays;

/**
 * 归并排序和快速排序的时间复杂度都为O(NlongN),不过归并排序需要额外的空间O(N),快速排序并不是稳定排序
 * 两者都使用递归进行排序
 */
public class SortTwo {

    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr) {
        mergeHelp(arr, 0, arr.length);
    }

    private static void mergeHelp(int[] arr, int i, int j) {
        if (i >= j - 1) {
            return;
        }
        mergeHelp(arr, i, (i + j) / 2);
        mergeHelp(arr, (i + j) / 2, j);
        merge(arr, i, j);
        System.out.println("i = " + i +  ", j = " + j + " " + Arrays.toString(arr));
    }

    private static void merge(int[] arr, int i, int j) {
        int[] temp = new int[j - i];
        int mid = (i + j) / 2;
        int left = i, right = mid, k = 0;
        while (left < mid && right < j) {
            if (arr[left] > arr[right]) {
                temp[k++] = arr[right++];
            } else {
                temp[k++] = arr[left++];
            }
        }
        int start = left, end = mid;
        if (right < j) {
            start = right;
            end = j;
        }
        while (start < end) {
            temp[k++] = arr[start++];
        }
        System.arraycopy(temp, 0, arr, i, j - i);
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr) {
        quickHelp(arr, 0 ,arr.length);
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr,int n) {
        quickHelp(arr, 0 ,n);
    }

    private static void quickHelp(int[] arr, int i, int j) {
        if (i >= j - 1){
            return;
        }
        int mid = partition(arr,i,j);
        System.out.println("i = " + i +  ", j = " + j + " " + Arrays.toString(arr));
        quickHelp(arr,i,mid);
        quickHelp(arr,mid + 1,j);
    }

    private static int partition(int[] arr, int i, int j) {
        int temp = i;
        for (int k = i; k < j - 1; k ++){
            if (arr[k] < arr[j - 1]){
                int t = arr[temp];
                arr[temp ++] = arr[k];
                arr[k] = t;
            }
        }
        int t = arr[temp];
        arr[temp] = arr[j - 1];
        arr[j - 1] = t;

        return temp;
    }

    private static void heapSort(int[] arr) {
        //step1:构造堆
        structureHeap(arr);
        System.out.println("after structure heap: " + Arrays.toString(arr));
        //step2:进行排序
        for (int i = arr.length - 1; i > 0; i--) {
            int t = arr[0];
            arr[0] = arr[i];
            arr[i] = t;
            heapify(arr, 0, i);
            System.out.println("i = " + i +  " " + Arrays.toString(arr));
        }
    }

    private static void heapify(int[] arr, int i, int length) {
        while (true){
            int temp = i;
            if ((i + 1) * 2 - 1 < length && arr[i] < arr[(i + 1) * 2 - 1]){
                temp = (i + 1) * 2 - 1;
            }
            if ((i + 1) * 2 < length && arr[temp] < arr[(i + 1) * 2 ]){
                temp = (i + 1) * 2;
            }
            if (temp == i){
                return;
            }
            int t = arr[temp];
            arr[temp] = arr[i];
            arr[i] = t;
            i = temp;
        }
    }

    private static void structureHeap(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int k = i;
            while (k > 0 && arr[k] > arr[(k - 1)/2]){
                int t = arr[k];
                arr[k] = arr[(k - 1)/2];
                arr[(k - 1)/2] = t;
                k = (k - 1)/2;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 5, 7, 26, 33, 95, 50, 84, 23, 18,18};
        int[] clone = arr.clone();
        mergeSort(clone);
        System.out.println("after merge sort :" + Arrays.toString(clone));

        clone = arr.clone();
        quickSort(clone);
        System.out.println("after quick sort :" + Arrays.toString(clone));

        clone = arr.clone();
        heapSort(clone);
        System.out.println("after heap sort :" + Arrays.toString(clone));


    }


}
