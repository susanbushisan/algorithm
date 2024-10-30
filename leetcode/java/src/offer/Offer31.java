package offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/ti-huan-kong-ge-lcof/">剑指 Offer 05. 替换空格</a>
 */
public class Offer31 {
    public static void main(String[] args) {
        Offer31 o = new Offer31();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(o.validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for (int i : popped) {
            while (stack.isEmpty() || stack.peek() != i) {
                if (j == pushed.length){
                    return false;
                }
                stack.push(pushed[j]);
                j ++ ;
            }
            stack.pop();
        }
        return true;
    }
}
