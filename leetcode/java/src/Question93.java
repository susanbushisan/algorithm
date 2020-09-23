import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question93 {


    public static void main(String[] args) {
        Question93 q = new Question93();
        long start = System.currentTimeMillis();
        System.out.println(q.restoreIpAddresses("25525511135"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 将s转换成一个ip，先来个暴力的，如果是求个数应该有DP解法
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int length = s.length();
        if (length > 12 || length < 4){
            return ans;
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    for (int l = 1; l < 4; l++) {
                        if (i + j + k + l != length){
                            continue;
                        }
                        String n1 = s.substring(0, i);
                        String n2 = s.substring(i, i + j);
                        String n3 = s.substring(i + j, i + j + k);
                        String n4 = s.substring(i + j + k);
                        if (checkValid(n1)&&checkValid(n2)&&checkValid(n3)&&checkValid(n4)){
                            ans.add(n1 + "." + n2 + "." + n3 + "." + n4);
                        }
                    }
                }
            }
        }
        return ans;
    }


    private boolean checkValid(String str){
        if (Integer.parseInt(str) <= 255) {
            return str.charAt(0) != '0' || str.length() == 1;
        }
        return false;
    }

}
