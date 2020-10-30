import java.util.*;

public class Question89 {
    public static void main(String[] args) {
        Question89 q = new Question89();

        long start = System.currentTimeMillis();
        System.out.println(q.grayCode(3));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public List<Integer> grayCode(int n) {
        int length = (int)Math.pow(2, n);
        List<Integer> find = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            find.add((int)Math.pow(2,i));
        }
        Deque<Integer> stack = new ArrayDeque<>(length);
        stack.push(0);
        helper(stack,find,length);
        List<Integer> ans = new ArrayList<>(stack);
        Collections.reverse(ans);
        return ans;
    }

    private boolean helper(Deque<Integer> stack,List<Integer> find,int length){
        if (stack.size() == length){
            return true;
        }
        Integer peek = stack.peek();
        for (Integer integer : find) {
            int i = peek ^ integer;
            if (!stack.contains(i)){
                stack.push(i);
                if (helper(stack, find,length)){
                    return true;
                }
                stack.pop();
            }
        }
        return false;
    }

}
