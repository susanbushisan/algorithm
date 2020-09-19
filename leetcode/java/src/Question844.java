
import java.util.Stack;

public class Question844 {
    public static void main(String[] args) {
        Question844 q = new Question844();
        long start = System.currentTimeMillis();
        System.out.println(q.backspaceCompare("a##c","#a#c"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack<Character>();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}
