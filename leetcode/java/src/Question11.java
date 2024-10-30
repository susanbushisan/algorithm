
/**
 * <b>Container With Most Water</b>
 * <p>
 * Given n non-negative integers a1, a2, ..., an ,where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class Question11 {
    public static void main(String[] args) {
        Question11 q11 = new Question11();
        long start = System.currentTimeMillis();
        int[] area = new int[]{1, 8, 16, 2, 5, 4, 8, 3, 7};
        System.out.println(q11.maxArea(area));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int maxAreaI(int[] height) {

        int left = 0, right = height.length - 1;
        int max = Math.min(height[left], height[right]) * (height.length - 1);

        while (left != right) {
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
        }
        return max;
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
