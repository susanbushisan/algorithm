
/**
 * 邪教自然有邪教的做法
 */
public class Question738 {
    public static void main(String[] args) {
        Question738 q738 = new Question738();
        long start = System.currentTimeMillis();
        System.out.println(q738.monotoneIncreasingDigits(331));
        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    public int monotoneIncreasingDigits(int N) {
        char[] number = String.valueOf(N).toCharArray();
        int i = 1;
        while (i<number.length){
            if (number[i-1] > number[i]){
                break;
            }
            i ++;
        }
        if (i==number.length){
            return N;
        }else {
            number[i - 1] --;
            while (i<number.length){
                number[i] = '9';
                i ++;
            }
            int temp = Integer.parseInt(new String(number));
            int j = 1;
            while (j<number.length){
                if (number[j-1] > number[j]){
                    return monotoneIncreasingDigits(temp);
                }
                j ++;
            }
            return temp;
        }

    }
}
