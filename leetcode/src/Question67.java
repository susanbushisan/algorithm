

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class Question67 {
    public static void main(String[] args) {
        Question67 q = new Question67();
        String a = "1000101010101010101010";
        String b = "101010101000101001001";

        long start = System.currentTimeMillis();
        System.out.println(q.addBinary1(a, b));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public String addBinary(String a, String b) {
        int bitCount = a.length() - b.length();
        StringBuilder sb = new StringBuilder();
        String aims;
        if (bitCount > 0) {
            sb.append(a);
            aims = b;
        } else {
            sb.append(b);
            aims = a;
        }
        sb.reverse();
        boolean step = false;
        for (int i = 0; i < aims.length(); i++) {
            int count = 0;
            if (sb.charAt(i) == '1') {
                count++;
            }
            if (aims.charAt(aims.length() - i - 1) == '1') {
                count++;
            }
            if (step) {
                count++;
            }
            if (count >= 2) {
                step = true;
                sb.replace(i,i + 1,String.valueOf(count-2));
            } else {
                step = false;
                sb.replace(i,i + 1,String.valueOf(count));
            }
        }
        if (step) {
            sb.append(1);
        }
        return sb.reverse().toString();

    }

    /**
     * 思路，先补齐，然后从后往前位相加，最后得到的字符串反转
     */
    public String addBinary1(String a, String b) {
        int bitCount = a.length() - b.length();
        if (bitCount > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bitCount; i++) {
                sb.append("0");
            }
            b = sb.append(b).toString();
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < -bitCount; i++) {
                sb.append("0");
            }
            a = sb.append(a).toString();
        }
        int c = a.length() - 1;
        boolean step = false;
        StringBuilder stringBuilder = new StringBuilder();
        while (c >= 0) {
            int count = 0;
            if (a.charAt(c) == '1') {
                count++;
            }
            if (b.charAt(c) == '1') {
                count++;
            }
            if (step) {
                count++;
            }
            if (count >= 2) {
                step = true;
                stringBuilder.append(count - 2);
            } else {
                step = false;
                stringBuilder.append(count);
            }
            c--;
        }
        if (step) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }
}
