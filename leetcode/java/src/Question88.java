
import java.util.Arrays;

/**
 * Question34
 */
public class Question88 {

    public static void main(String[] args) {
        Question88 q = new Question88();
        int[] nums1 = {
                1, 2, 3, 0, 0, 0
        };
        int[] nums2 = {
                2, 5, 6
        };
        int m = 3;
        int n = 3;
        long start = System.currentTimeMillis();
        q.merge(nums1, m, nums2, n);
        System.out.println(System.currentTimeMillis() - start + "ms");
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (p1 == -1){
                nums1[i] = nums2[p2];
                p2 --;
            } else if (p2 == -1) {
                break;
            }else {
                if (nums1[p1] > nums2[p2]){
                    nums1[i] = nums1[p1];
                    p1 --;
                }else {
                    nums1[i] = nums2[p2];
                    p2 --;
                }
            }
        }
    }

}