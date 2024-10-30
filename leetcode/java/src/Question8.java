
public class Question8 {
    public static void main(String[] args) {
        Question8 q = new Question8();
        long start = System.currentTimeMillis();
        String s = "42";
        System.out.println(q.myAtoi(s));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int myAtoi(String s) {
        int i = 0;
        char c;
        long res = 0;
        // 读入字符串并丢弃无用的前导空格
        while (i < s.length() && Character.isSpaceChar(c = s.charAt(i))) {
            i++;
        }
        if (i == s.length()) {
            return 0;
        }
        // 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
        boolean plus = true;
        c = s.charAt(i);
        if (c == '+' || c == '-') {
            i++;
            if (c == '-') {
                plus = false;
            }
        }
        if (i == s.length()) {
            return 0;
        }
        // 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
        while (i < s.length() && Character.isDigit(c = s.charAt(i))) {
            res = res * 10 + c - '0';
            if (res > Integer.MAX_VALUE) {
                return plus ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }
        return plus ? (int) res : (int) -res;
    }

}
