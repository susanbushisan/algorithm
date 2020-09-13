
/**
 * 最大连续乘积
 */
public class Question172 {

 
    public static void main(String[] args) {
        Question172 q = new Question172();
        long start = System.currentTimeMillis();
        System.out.println(q.trailingZeroes(25));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     *  阶乘效率也太慢了吧，不能接受
     */
    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5){
            n = n/5;
            res +=n;
        }
        return res;
    }


}
