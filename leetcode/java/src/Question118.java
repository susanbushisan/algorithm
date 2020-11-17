

import java.util.*;

public class Question118 {


    public static void main(String[] args) {
        Question118 q = new Question118();
        long start = System.currentTimeMillis();
        q.generate(5).forEach(System.out::println);
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j <= i; j++) {
                if (j == i){
                    temp.add(1);
                    break;
                }
                List<Integer> pre = ans.get(ans.size() - 1);
                temp.add(pre.get(j - 1)+pre.get(j));
            }
            ans.add(temp);
        }
        return ans;
    }

}
