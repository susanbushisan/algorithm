package offer;

public class Offer16 {
    public static void main(String[] args) {
        Offer16 o = new Offer16();
        System.out.println(o.myPow(2, -2147483648));
    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;

    }
}
