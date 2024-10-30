package offer;

import java.util.*;

public class Offer38 {

    public static void main(String[] args) {
        Offer38 o = new Offer38();
        System.out.println(Arrays.toString(o.permutation("abc")));
    }

    public String[] permutation(String s) {
        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean[] flag = new boolean[s.length()];
        permutation(s,sb,flag,res);
        return res.toArray(new String[0]);
    }

    private void permutation(String s, StringBuilder sb, boolean[] flag, Set<String> res) {
        if (sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!flag[i]) {
                sb.append(s.charAt(i));
                flag[i] =true;
                permutation(s, sb, flag, res);
                flag[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}
