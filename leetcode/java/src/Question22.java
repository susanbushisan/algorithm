import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Question22 {


    public static void main(String[] args) {
        Question22 q = new Question22();
        long start = System.currentTimeMillis();
        System.out.println(q.generateParenthesis(3));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public List<String> generateParenthesisI(int n) {
        List<String> ans = new ArrayList<>();
        Deque<Character> stack = new LinkedList<>();
        helper(stack, n, n, ans);
        return ans;
    }

    private void helper(Deque<Character> stack, int left, int right, List<String> ans) {
        if (left > 0) {
            stack.add('(');
            helper(stack, left - 1, right, ans);
            stack.removeLast();
        }
        if (right > 0 && right > left) {
            stack.add(')');
            helper(stack, left, right - 1, ans);
            stack.removeLast();
        } else if (right == 0) {
            StringBuilder sb = new StringBuilder();
            for (Character character : stack) {
                sb.append(character);
            }
            ans.add(sb.toString());
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        help(new StringBuilder(), n, n, res);
        return res;
    }

    private void help(StringBuilder sb, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left == right) {
            sb.append('(');
            help(sb, left - 1, right, res);
            sb.deleteCharAt(sb.length() - 1);
        } else if (left == 0) {
            sb.append(')');
            help(sb, left, right - 1, res);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append('(');
            help(sb, left - 1, right, res);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(')');
            help(sb, left, right - 1, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
