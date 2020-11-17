import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 */
public class Question17 {
    public static void main(String[] args) {
        Question17 question17 = new Question17();
        long start = System.currentTimeMillis();
        System.out.println(question17.letterCombinations("234"));
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

    public List<String> letterCombinationsBacktracking(String digits) {
        if (digits.length() == 0){
            return new ArrayList<>();
        }
        String[] dict = {
                "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(digits,0,dict,sb,res);
        return res;
    }

    private void helper(String digits,int index,String[] dict,StringBuilder sb,List<String> res){
        if (index == digits.length()){
            res.add(sb.toString());
            return;
        }
        String op = dict[digits.charAt(index) - 50];
        for (int i = 0; i < op.length(); i++) {
            sb.append(op.charAt(i));
            helper(digits, index + 1, dict, sb, res);
            sb.deleteCharAt(index);
        }
    }
}
