import util.TimerUtils;

public class Question326 {
    public static void main(String[] args) {
        Question326 q = new Question326();
        int num = 19684;
        System.out.println(TimerUtils.op(() -> q.isPowerOfThree(num)));
    }

    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
