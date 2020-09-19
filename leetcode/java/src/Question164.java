import java.util.Arrays;

public class Question164 {
    public static void main(String[] args) {
        Question164 question164 = new Question164();
        int[] array = {3,6,9,99999999,Integer.MAX_VALUE};
        long start = System.currentTimeMillis();
        System.out.println(question164.maximumGaBucket(array));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i + 1] - nums[i]);
        }
        return max;
    }

    /**
     * 计数排序的变种，用一个标记表示在此处有没有数字
     */
    public int maximumGapCount(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        int min = nums[0],max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        boolean[] counter = new boolean[max -min + 1];
        for (int num : nums) {
            counter[num - min] = true;
        }
        int ans = 0,pre = -1;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i]){
                if (pre != -1){
                    ans = Math.max(ans,i - pre);
                }
                pre = i;
            }
        }
        return ans;
    }

    public int maximumGaBucket(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        int min = nums[0],max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        //计算桶大小,桶数量至少一个
        int bucketSize = Math.max((max - min) / (nums.length - 1), 1);
        Bucket[] buckets = new Bucket[(max - min) / bucketSize + 1];
        //入桶,每个桶只关心桶内的最大值和最小值
        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            if (buckets[idx] == null) buckets[idx] = new Bucket();
            buckets[idx].max = Math.max(num, buckets[idx].max);
            buckets[idx].min = Math.min(num, buckets[idx].min);
        }
        //前一个桶的 max
        int preMax = -1;
        //最大间隔
        int maxGap = 0;
        for (Bucket bucket : buckets) {
            //桶不为空,并且不是第一个桶
            if (bucket != null && preMax != -1) {
                //桶之间的间隔
                maxGap = Math.max(maxGap, bucket.min - preMax);
            }
            //记录前一个桶的 max
            if (bucket != null) {
                preMax = bucket.max;
            }
        }
        return maxGap;
    }

    //桶结构,桶内只关心最大值、最小值
    static class Bucket {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

}
