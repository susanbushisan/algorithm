
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Thinking: can use stack to store charset and compared
 */
public class Question20 {
    public static void main(String[] args) {
        Question20 q20 = new Question20();
        String str = "{[]}";
        long start = System.currentTimeMillis();
        System.out.println(q20.isValid(str));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public boolean isValidI(String s) {
        String left = "({[";
        String right = ")}]";
        Deque<Character> res = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (left.indexOf(c) != -1) {
                res.add(c);
            } else {
                if (res.size() > 0 && left.charAt(right.indexOf(c)) == res.getLast()) {
                    res.pollLast();
                } else {
                    return false;
                }
            }
        }
        return res.size() == 0;
    }

    public boolean isValid(String s) {
        String left = "{[(", right = "}])";
//        char[][] bracket = {{'{','[','}'},{'}',']',')'}}
        Deque<Character> queue = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (left.indexOf(c) != -1) {
                queue.push(c);
            }else if (right.indexOf(c) != -1){
                if (!queue.isEmpty() && left.indexOf(queue.peek()) == right.indexOf(c)){
                    queue.pop();
                }else {
                    return false;
                }
            }
        }
        return queue.isEmpty();
    }
}
