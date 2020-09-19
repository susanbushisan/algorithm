import java.util.Deque;
import java.util.LinkedList;

public class Question150 {
    public static void main(String[] args) {
        Question150 q70 = new Question150();
        String[] tokens = {
                "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"
        };
        long start = System.currentTimeMillis();
        System.out.println(q70.evalRPN(tokens));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int var1 = stack.pop();
                    int var2 = stack.pop();
                    stack.push(var1 + var2);
                    break;
                }
                case "-": {
                    int var1 = stack.pop();
                    int var2 = stack.pop();
                    stack.push(var2 - var1);
                    break;
                }
                case "*": {
                    int var1 = stack.pop();
                    int var2 = stack.pop();
                    stack.push(var1 * var2);
                    break;
                }
                case "/": {
                    int var1 = stack.pop();
                    int var2 = stack.pop();
                    stack.push(var2 / var1);
                    break;
                }
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }
}
