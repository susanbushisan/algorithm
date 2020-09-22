
/**
 * 位1的个数
 */
public class Question191 {


    public static void main(String[] args) {
        Question191 q = new Question191();
        long start = System.currentTimeMillis();
        System.out.println(q.hammingWeightRight(-3));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 二进制的题目，除n取余法必须有牌面
     */
    public int hammingWeightRight(int n) {
        int count = 0;
        boolean flag = true;
        if (n < 0) {
            flag = false;
            n = ~n;
        }
        while (n != 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }
        return flag ? count : 32 - count;
    }

    public int hammingWeight(int n) {
        int count = 0;
        String s = Integer.toBinaryString(n);
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }


}
