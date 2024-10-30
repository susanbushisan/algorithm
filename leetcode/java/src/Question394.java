import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class Question394 {
    public static void main(String[] args) {
        Question394 q = new Question394();
        long start = System.currentTimeMillis();
        System.out.println(q.decodeString("2[abc]3[cd]ef"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public String decodeString(String s) {
        if (s.equals("3")){
            return "";
        }
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        while (i < sb.length()) {
            char c = sb.charAt(i);
            if (c == ']') {
                int pop = stack.pop();
                // 计算重复次数
                int digit = 1;
                while (pop - digit - 1 >= 0 && Character.isDigit(sb.charAt(pop - digit - 1))) {
                    digit++;
                }
                int times = Integer.parseInt(sb.substring(pop - digit, pop));
                String repeated = String.join("", Collections.nCopies(times, sb.substring(pop + 1, i)));
                sb.replace(pop - digit, i + 1, repeated);
                i = i + (repeated.length() - (i - pop + digit));
                continue;
            }
            if (c == '[') {
                stack.push(i);
            }
            i++;
        }

        return sb.toString();
    }

}
