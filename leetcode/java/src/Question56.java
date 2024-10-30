import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question56 {
    public static void main(String[] args) {
        Question56 q = new Question56();
        int[][] intervals = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        long start = System.currentTimeMillis();
        System.out.println(Arrays.deepToString(q.merge(intervals)));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] target = res.get(res.size()-1);
            if (intervals[i][0] <= target[1] && intervals[i][1] >= target[0]){
//                target[0] = Math.min(target[0], intervals[i][0]);
                target[1] = Math.max(target[1], intervals[i][1]);
            }else {
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][]);
//
//        if (intervals.length == 0) {
//            return new int[0][2];
//        }
//        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
//        List<int[]> merged = new ArrayList<>();
//        for (int i = 0; i < intervals.length; ++i) {
//            int L = intervals[i][0], R = intervals[i][1];
//            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
//                merged.add(new int[]{L, R});
//            } else {
//                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
//            }
//        }
//        return merged.toArray(new int[merged.size()][]);

    }

    public int[][] mergeO(int[][] intervals) {
        int start = 1;
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j] != null && intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                    intervals[i][0] = Math.min(intervals[j][0], intervals[i][0]);
                    intervals[i][1] = Math.max(intervals[j][1], intervals[i][1]);
                    intervals[j] = null;
                    start--;
                }
            }
            start++;
        }
        int[][] res = new int[start][2];
        int index = 0;
        for (int i = 0; i < start; i++) {
            while (intervals[index] == null) {
                index++;
            }
            res[i] = intervals[index];
            index++;
        }
        return res;
    }
}
