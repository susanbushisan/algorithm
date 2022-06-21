import java.util.ArrayDeque;
import java.util.Deque;

public class Question2104 {
    public static void main(String[] args) {
        Question2104 q = new Question2104();
        int[] nums = {4, -2, -3, 4, 1};
        long start = System.currentTimeMillis();
        System.out.println(q.subArrayRanges(nums));
        System.out.println(q.subArrayRanges2(nums));
        System.out.println(q.subArrayRanges3(nums));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public long subArrayRanges(int[] nums) {
        int length = nums.length;
        int[][][] dp = new int[length][length][3];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                int num = nums[j];
                if (i == j) {
                    dp[i][j][1] = num;
                    dp[i][j][2] = num;
                } else {
                    if (num < dp[i][j - 1][1]) {
                        dp[i][j][0] = Math.abs(num - dp[i][j - 1][2]);
                        dp[i][j][1] = num;
                        dp[i][j][2] = dp[i][j - 1][2];
                    } else if (num > dp[i][j - 1][2]) {
                        dp[i][j][0] = Math.abs(num - dp[i][j - 1][1]);
                        dp[i][j][1] = dp[i][j - 1][1];
                        dp[i][j][2] = num;
                    } else {
                        dp[i][j][1] = dp[i][j - 1][1];
                        dp[i][j][2] = dp[i][j - 1][2];
                        dp[i][j][0] = Math.max(dp[i + 1][j][0], dp[i][j - 1][0]);
                    }
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                sum += dp[i][j][0];
            }
        }
        return sum;
    }

    public long subArrayRanges2(int[] nums) {
        int length = nums.length;
        long res = 0;
        for (int i = 0; i < length - 1; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i + 1; j < length; j++) {
                if (min > nums[j]) {
                    res += max - nums[j];
                    min = nums[j];
                } else if (max < nums[j]) {
                    res += nums[j] - min;
                    max = nums[j];
                } else {
                    res += max - min;
                }
            }
        }
        return res;
    }

    public long subArrayRanges3(int[] nums) {
        int length = nums.length;
        int[] minLeft = new int[length];
        int[] minRight = new int[length];
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];
        Deque<Integer> minStack = new ArrayDeque<>();
        Deque<Integer> maxStack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!minStack.isEmpty() && nums[minStack.peek()] > nums[i]) {
                minStack.pop();
            }
            minLeft[i] = minStack.isEmpty() ? -1 : minStack.peek();
            minStack.push(i);
            while (!maxStack.isEmpty() && nums[maxStack.peek()] <= nums[i]) {
                maxStack.pop();
            }
            maxLeft[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(i);

        }
        minStack.clear();
        maxStack.clear();
        for (int i = length - 1; i >= 0; i--) {
            while (!minStack.isEmpty() && nums[minStack.peek()] >= nums[i]) {
                minStack.pop();
            }
            minRight[i] = minStack.isEmpty() ? length : minStack.peek();
            minStack.push(i);

            while (!maxStack.isEmpty() && nums[maxStack.peek()] < nums[i]) {
                maxStack.pop();
            }
            maxRight[i] = maxStack.isEmpty() ? length : maxStack.peek();
            maxStack.push(i);
        }

        long sumMax = 0, sumMin = 0;
        for (int i = 0; i < length; i++) {
            sumMax += (long) (maxRight[i] - i) * (i - maxLeft[i]) * nums[i];
            sumMin += (long) (minRight[i] - i) * (i - minLeft[i]) * nums[i];
        }
        return sumMax - sumMin;
    }

}
