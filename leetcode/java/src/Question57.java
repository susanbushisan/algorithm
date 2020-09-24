import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question57 {
    public static void main(String[] args) {
        Question57 q = new Question57();
        int[][] intervals = new int[][]{
                {1, 5},
                {7, 9},
        };
        int[] newInterval = {5,7};

        long start = System.currentTimeMillis();
        System.out.println(Arrays.deepToString(q.insert(intervals, newInterval)));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp = new ArrayList<>();
        int status = 0;
        for (int[] interval : intervals) {
            for (int j = 0; j < 2; j++) {
                if (status == 0) {
                    if (interval[j] >= newInterval[0]) {
                        if (j == 1) {
                            newInterval[0] = interval[0];
                        }
                        status = 1;
                    } else if (j == 1) {
                        temp.add(interval);
                    }
                }
                if (status == 1) {
                    if (interval[j] > newInterval[1]) {
                        if (j == 1) {
                            newInterval[1] = interval[1];
                        }
                        temp.add(newInterval);
                        status = 2;
                        continue;
                    }
                }
                if (status == 2 && j == 1) {
                    temp.add(interval);
                }

            }
        }
        if (status != 2){
            temp.add(newInterval);
        }

        int[][] ans = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }
}
