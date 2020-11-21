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

    public static void main(String[] args) {
        int[] arr = {13, 5, 7, 26, 33, 95, 50, 84, 23, 18,18};
        int[] clone = arr.clone();
        mergeSort(clone);
        System.out.println("after merge sort :" + Arrays.toString(clone));

        clone = arr.clone();
        quickSort(clone);
        System.out.println("after insertion sort :" + Arrays.toString(clone));


    }
}
