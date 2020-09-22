public class Question50 {
    public static void main(String[] args) {
        Question50 q50 = new Question50();
        long start = System.currentTimeMillis();
        System.out.println(q50.myPow(2.00000, -2147483648));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N == 0) return 1;
        boolean behindZero = true;
        if (N < 0) {
            behindZero = false;
            N = -N;
        }
        double ans = 1;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x;
            }
            x *= x;
            N = N << 1;
        }
        return behindZero ? ans : 1 / ans;
    }

}
