package offer;

public class Offer39 {

    public int majorityElement(int[] nums) {
        int vote = 0;
        int n = 0;
        for (int num : nums) {
            if (vote == 0) {
                n = num;
            }
            vote += num == n ? 1 : -1;
        }
        return n;
    }
}
