import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 */
public class Question17 {
    public static void main(String[] args) {
        Question17 question17 = new Question17();
        long start = System.currentTimeMillis();
        System.out.println(question17.letterCombinations(""));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return new ArrayList<>();
        }
        String[] dict = {
          "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        int size = 1;
        char[] chars = digits.toCharArray();
        char[] index = new char[digits.length()];
        //算出结果的长度
        for (char aChar : chars) {
            size *= dict[aChar - 50].length();
        }
        List<String> res = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            int c = i;
            //除n取余法
            for (int j = 0; j < digits.length(); j++) {
                String deal = dict[digits.charAt(j) - 50];
                index[j] = deal.charAt(c % deal.length());
                c = c / deal.length();
            }
            res.add(new String(index));
        }
        return res;
    }
}
