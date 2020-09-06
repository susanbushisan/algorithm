
/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 */
public class Question58 {
    public static void main(String[] args) {
        Question58 q = new Question58();
        String a = "Hello World";

        long start = System.currentTimeMillis();
        System.out.println(q.lengthOfLastWord(a));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 反着来就可以了，先判断字符串是否包含字符，不包含返回0
     * 然后从后往前招第一个非空白字符，然后继续找第一个空白字符，两者的差即为答案
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int strLen = s.length();
        if (strLen == 0){
            return 0;
        }
        boolean flag = false;
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                flag = true;
            }
        }
        if (!flag){
            return 0;
        }
        int endPoint,startPoint;
        while (Character.isWhitespace(s.charAt(strLen - 1))){
            strLen --;
        }
        endPoint = strLen;
        while (strLen > 0 &&!Character.isWhitespace(s.charAt(strLen - 1))){
            strLen --;
        }
        startPoint = strLen;
        return endPoint - startPoint;
    }

}
