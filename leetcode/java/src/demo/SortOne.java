package demo;

import java.util.Arrays;

/**
 * 应该有个前提，是否允许修改链表的节点value值，
 * 还是只能改变节点的位置。一般而言，考虑只能改变节点位置，冒泡排序相比于
 * 数组实现，比较次数一致，但交换时操作更复杂；插入排序，比较次数一致，
 * 不需要再有后移操作，找到位置后可以直接插入，但排序完毕后可能需要倒置链表；
 * 选择排序比较次数一致，交换操作同样比较麻烦。综上，时间复杂度和空间复杂度
 * 并无明显变化，若追求极致性能，冒泡排序的时间复杂度系数会变大，插入排序
 * 系数会减小，选择排序无明显变化。
 */
public class SortOne {

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) { // 交换
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            System.out.println("after times:" + i + Arrays.toString(arr));
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }

    /**
     * 插入排序
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > val) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = val;
            System.out.println("after times:" + i + Arrays.toString(arr));
        }
    }

    /**
     * 选择排序
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
            System.out.println("after times:" + i + Arrays.toString(arr));

        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 5, 7, 26, 33, 95, 50, 84, 23, 18};
        int[] clone = arr.clone();
        bubbleSort(clone);
        System.out.println("after bubble sort :" + Arrays.toString(clone));

        clone = arr.clone();
        insertionSort(clone);
        System.out.println("after insertion sort :" + Arrays.toString(clone));

        clone = arr.clone();
        selectionSort(clone);
        System.out.println("after selection sort :" + Arrays.toString(clone));
    }
}
