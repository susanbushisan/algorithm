import util.TimerUtils;

public class Question461 {
    public static void main(String[] args) {
        Question461 q = new Question461();
        System.out.println(TimerUtils.op(() -> q.hammingDistance(1, 4)));
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
