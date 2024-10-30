

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class Question69 {
    public static void main(String[] args) {
        Question69 q = new Question69();

        long start = System.currentTimeMillis();
        System.out.println(q.mySqrt(1));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int mySqrtI(int x) {
        int high = x, low = 0;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if ((long) mid * mid <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + ((high - low) >> 1);
    }


    public int mySqrt(int x) {
        int high = x, low = 0;
        int res = 0;
        while (high >= low) {
            int mid = low + ((high - low) >> 1);
            long h = (long) mid * mid;
            if (h == x) {
                return mid;
            } else if (h > x) {
                high = mid - 1;
            } else {
                res = mid;
                low = mid + 1;
            }
        }
        return res;
    }
}
