package offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer33 {

    public static void main(String[] args) {
        Offer33 o = new Offer33();
        System.out.println(o.verifyPostorder(new int[]{5, 2, -17, -11, 25, 76, 62, 98, 92, 61}));
    }

    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length);
    }

    private boolean helper(int[] postorder, int left, int right) {
        if (left >= right - 1) {
            return true;
        }
        int val = postorder[right - 1];
        int j = left;
        for (int i = right - 2; i >= left; i--) {
            if (j == left && postorder[i] < val) {
                j = i + 1;
            } else if (j != left && postorder[i] > val) {
                return false;
            }
        }
        return helper(postorder, left, j) && helper(postorder, j, right - 1);

    }

}
