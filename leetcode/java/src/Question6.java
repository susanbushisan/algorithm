
public class Question6 {
    public static void main(String[] args) {
        Question6 q6 = new Question6();
        long start = System.currentTimeMillis();
        String s = "PAYPALISHIRING";
        System.out.println(q6.convertFind(s,4));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public String convert(String s, int numRows) {
        if (numRows == 1 )return s;
        StringBuilder[] chars = new StringBuilder[numRows];
        for (int i = 0; i <numRows ; i++) {
            chars[i] = new StringBuilder();
        }
        int i = 0;
        boolean flag = true;
        for (int j = 0; j < s.length(); j++) {
            chars[i].append(s.charAt(j));
            i = flag ? i + 1: i - 1;
            if (i == numRows - 1){
                flag = false;
            }else if (i == 0){
                flag = true;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            result.append(chars[j].toString());
        }
        return result.toString();
    }

    public String convertFind(String s, int numRows) {

        if (numRows == 1) return s;
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                result.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n){
                    result.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return result.toString();
    }
}
