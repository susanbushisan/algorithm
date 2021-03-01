package demo;

/**
 * 堆是完全二叉树
 */
public class Heap {

    private int[] a;
    private int maxSize;
    private int size;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        maxSize = capacity;
        size = 0;
    }

    public void insert(int data) {
        if (size >= maxSize) {
            return;
        }
        size++;
        a[size] = data;
        int i = size;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            int temp = a[i];
            a[i] = a[i / 2];
            a[i / 2] = temp;
            i /= 2;
        }
    }

    public int removeTop() {
        if (size == 0) {
            return -1;
        }
        int res = a[1];
        a[1] = a[size];
        a[size] = 0;
        size--;
        heapify(a, size, 1);
        return res;
    }

    /* 自上而下进行堆化 */
    private void heapify(int[] a, int size, int i) {
        while (true) {
            int maxPos = i;
            //不知道需要是和最大的元素交换还是和比堆顶元素大交换即可
            if (i * 2 <= size && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= size && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            int temp = a[maxPos];
            a[maxPos] = a[i];
            a[i] = temp;

            i = maxPos;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(12);
        heap.insert(123);
        heap.insert(234);
        heap.insert(345);
        heap.insert(456);
        heap.insert(567);
        heap.insert(678);
        System.out.println(heap.removeTop());
        System.out.println(heap.removeTop());
        System.out.println(heap.removeTop());
        System.out.println(heap.removeTop());
        System.out.println(heap.removeTop());
        System.out.println(heap.removeTop());

    }
}
