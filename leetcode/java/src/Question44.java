

import java.util.ArrayList;
import java.util.List;

public class Question44 {


    public static void main(String[] args) {
        Question44 q = new Question44();
        String s = "abcedced", p = "ab*c?d";
        long start = System.currentTimeMillis();
        System.out.println(q.isMatch(s, p));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 动态规划
     */
    public boolean isMatchEasy(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public boolean isMatch(String s, String p) {
        List<String> split = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '*') {
                split.add(new String(sb));
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        split.add(new String(sb));
        //情况1，左右无*
        if (split.size() == 1){
            if (s.length() != p.length()){
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                char c = p.charAt(i);
                if (s.charAt(i) != c && c != '?'){
                    return false;
                }
            }
            return true;
        }
        String target = s;
        if (likeStartWith(target,split.get(0))){
            target = target.substring(split.get(0).length());
        }else {
            return false;
        }
        for (int i = 1; i < split.size() - 1; i++) {
            int index = likeEquals(target,split.get(i));
            if (index != -1){
                target = target.substring(index);
            }else {
                return false;
            }
        }
        return likeEndWith(target,split.get(split.size() - 1));

    }

    private boolean likeStartWith(String target, String s) {
        if (target.length() < s.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (target.charAt(i) != c && c != '?'){
                return false;
            }
        }
        return true;
    }

    private boolean likeEndWith(String target, String s) {
        int index = target.length() - s.length();
        if (index<0){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (target.charAt(i +index) != c && c != '?'){
                return false;
            }
        }
        return true;
    }

    private int likeEquals(String source, String p) {
        if (p.length() > source.length()) {
            return -1;
        }
        for (int i = 0; i <= source.length() - p.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < p.length(); j++) {
                char t = p.charAt(j);
                if (source.charAt(i + j) != t && t != '?') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i + p.length();
            }
        }
        return -1;
    }
}
