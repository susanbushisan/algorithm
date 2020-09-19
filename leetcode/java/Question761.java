
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目有点难懂，第一件事就是读懂题目的意思
 * <p>
 *     Special binary strings are binary strings with the following two properties:
 *
 *      The number of 0's is equal to the number of 1's.
 *      Every prefix of the binary string has at least as many 1's as 0's.
 * </p>
 * 特殊的二进制strings有如下两个特征
 * 1.在这个strings中0和1的数量相等
 * 2.在每个charset之前的string必须满足1的数量大于0的数量
 * eg. 1001不满足第二条，因为在arr[3]时的前缀为100，不满足1的数量大于等于0.
 * 由此可以得到一个隐性的结论，特殊的二进制必须满足最后一位是0的需求。
 */
public class Question761 {
    public static void main(String[] args) {
        Question761 q = new Question761();
        long start = System.currentTimeMillis();
        System.out.println(q.makeLargestSpecial("11011000"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public String makeLargestSpecial(String S) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int start = 0;
        int countOne = 0;
        for(int i = 0; i < S.length(); ++i) {
            countOne += S.charAt(i) == '1' ? 1 : -1;
            if(countOne == 0) {
                String str = S.substring(start + 1, i);
                list.add("1" + makeLargestSpecial(str) + "0");
                start = i + 1;
            }
        }
        Collections.sort(list);
        for(int i = list.size() - 1; i >= 0; --i)
            sb.append(list.get(i));
        return sb.toString();
    }

}
