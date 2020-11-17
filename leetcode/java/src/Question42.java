import java.util.Deque;
import java.util.LinkedList;

public class Question42 {


    public static void main(String[] args) {
        Question42 q = new Question42();
        int[] height = {
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        };
        long start = System.currentTimeMillis();
        System.out.println(q.trapDpR(height));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int trap(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int area = 0, start = 0, minHeight = height[0];
        for (int i = 1; i < height.length; i++) {
            if (minHeight < height[i]) {
                int w = i - start - 1;
                area += w * minHeight;
                for (int j = start + 1; j < i; j++) {
                    area -= height[j];
                }
                minHeight = height[i];
                start = i;
            }
        }
        start = height.length - 1;
        minHeight = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (minHeight <= height[i]) {
                int w = start - i - 1;
                area += w * minHeight;
                for (int j = start - 1; j > i; j--) {
                    area -= height[j];
                }
                minHeight = height[i];
                start = i;
            }
        }
        return area;
    }

    public int trapDp(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int ans = 0;
        int size = height.length;
        int[] leftMax = new int[size], rightMax = new int[size];
        leftMax[0] = height[0];
        rightMax[size - 1] = height[size - 1];

        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            rightMax[size - 1 - i] = Math.max(height[size - 1 - i], rightMax[size - i]);
        }

        for (int i = 0; i < size; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public int trapStack(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = i - stack.peek() - 1;
                int bounded_height = Math.min(height[i], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(i);
        }
        return ans;

    }

    public int trapDpR(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }

}
