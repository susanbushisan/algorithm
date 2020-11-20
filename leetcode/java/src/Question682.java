import java.util.*;

public class Question682 {
    public static void main(String[] args) {
        Question682 q = new Question682();
        String[] ops = {
                "5","-2","4","C","D","9","+","+"
        };
        long start = System.currentTimeMillis();

        System.out.println(q.calPoints(ops));

        System.out.println(System.currentTimeMillis() - start + "ms");

    }
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : ops) {
            if (op.equals("+")){
                int pop = stack.pop();
                int n = pop + stack.peek();
                stack.push(pop);
                stack.push(n);
            }else if (op.equals("C")){
                stack.pop();
            }else if (op.equals("D")){
                stack.push(stack.peek() *2);
            }else {
                stack.push(Integer.parseInt(op));
            }
        }
        int ans = 0;
        for (Integer integer : stack) {
            ans += integer;
        }
        return ans;
//        return stack.stream().mapToInt(x->x).sum();
    }
}
