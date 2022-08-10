public class Question307 {

    static class NumArray {

        private int[] nums;

        private int size;

        private int[] sum;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.size = (int) Math.sqrt(nums.length);
            sum = new int[(nums.length + size) / size];
            for (int i = 0; i < nums.length; i++) {
                sum[i / size] += nums[i];
            }
        }

        public void update(int index, int val) {
            sum[index / size] += val - nums[index];
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            int b1 = left / size;
            int b2 = right / size;
            if (b1 == b2) {
                int sum = 0;
                for (int j = left; j <= right; j++) {
                    sum += nums[j];
                }
                return sum;
            }
            int i1 = left % size;
            int i2 = right % size;
            int count = 0;
            for (int i = i1; i < size; i++) {
                count += nums[b1 * size + i];
            }
            for (int i = 0; i <= i2; i++) {
                count += nums[b2 * size + i];
            }
            for (int i = b1 + 1; i < b2; i++) {
                count += sum[i];
            }
            return count;
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
}
