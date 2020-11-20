import java.util.ArrayDeque;
import java.util.Deque;

public class Question224 {
    public static void main(String[] args) {
        Question224 q = new Question224();

        long start = System.currentTimeMillis();

        System.out.println(q.calculate("(1+(4+5+2)-3)+(6+8)"));

        System.out.println(System.currentTimeMillis() - start + "ms");

    }

    public int evaluateExpr(Deque<Object> stack) {
        int res = 0;
        if (!stack.isEmpty()) {
            res = (int) stack.pop();
        }
        while (!stack.isEmpty() && !((char) stack.peek() == ')')) {
            char sign = (char) stack.pop();
            if (sign == '+') {
                res += (int) stack.pop();
            } else {
                res -= (int) stack.pop();
            }
        }
        return res;
    }


    public int calculate(String s) {
        Deque<Object> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        String newS = sb.append("(").append(s).append(")").reverse().toString();

        int operand = 0;
        int n = 0;

        for (int i = 0; i < newS.length(); i++) {

            char ch = newS.charAt(i);

            if (Character.isDigit(ch)) {
                operand = (int) Math.pow(10, n) * (ch - '0') + operand;
                n += 1;

            } else if (ch != ' ') {
                if (n != 0) {
                    stack.push(operand);
                    n = 0;
                    operand = 0;

                }
                if (ch == '(') {
                    int res = evaluateExpr(stack);
                    stack.pop();
                    stack.push(res);

                } else {
                    stack.push(ch);
                }
            }
        }
        if (n != 0) {
            stack.push(operand);
        }
        return (int)stack.pop();
    }
}
