import java.util.ArrayDeque;
import java.util.Deque;

public class Question84 {


    public static void main(String[] args) {
        Question84 q = new Question84();
        int[] heights = {
                2, 1, 5, 6, 2, 3
        };
        //answer = 10
        long start = System.currentTimeMillis();
        System.out.println(q.largestRectangleArea(heights));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res = 0;

        Deque<Integer> stack =new  ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                //最小元素的宽对应的是全部
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }

        return res;
    }

}
