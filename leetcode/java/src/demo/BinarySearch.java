package demo;

public class BinarySearch {

    public static void main(String[] args) {
        //普通无重复的二叉搜索
        int[] a = new int[]{
                2, 3, 5, 7, 43, 65, 87, 94, 123, 453, 1235
        };
        System.out.println(binarySearch(a, 65));

        //变体1：查找第一个值等于给定值的元素
        int[] a1 = new int[]{
                2, 3, 5, 7, 43, 65, 65, 65, 87, 94, 123, 453, 1235
        };
        System.out.println(binarySearchChange1(a1, 65));
        //变体2：查找最后一个值等于给定值的元素
        int[] a2 = new int[]{
                2, 3, 5, 7, 43, 65, 65, 65, 87, 94, 123, 453, 1235
        };
        System.out.println(binarySearchChange2(a2, 65));
        //变体3：查找第一个大于等于给定值的元素
        int[] a3 = new int[]{
                2, 3, 5, 7, 43, 65, 65, 65, 87, 94, 123, 453, 1235
        };
        System.out.println(binarySearchChange3(a3, 88));
        //变体4：查找最后一个小于等于给定值的元素
        int[] a4 = new int[]{
                2, 3, 5, 7, 43, 65, 65, 65, 87, 94, 123, 453, 1235
        };
        System.out.println(binarySearchChange4(a4, 64));
    }

    private static int binarySearchChange4(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == target) {
                if (mid == 0 || a[mid - 1] != target) {
                    return mid - 1;
                }else {
                    high = mid - 1;
                }
            }else if (a[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private static int binarySearchChange3(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == target) {
                if (mid == 0 || a[mid + 1] != target) {
                    return mid + 1;
                }else {
                    low = mid + 1;
                }
            }else if (a[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int binarySearchChange2(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == target) {
                if (mid == 0 || a[mid + 1] != target) {
                    return mid;
                }else {
                    low = mid + 1;
                }
            }else if (a[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchChange1(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == target) {
                if (mid == 0 || a[mid -1] != target) {
                    return mid;
                }else {
                    high = mid - 1;
                }
            }else if (a[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == target) {
                return mid;
            }
            if (a[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
