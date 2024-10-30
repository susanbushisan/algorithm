import java.util.HashMap;

public class Question344 {

    public static void main(String[] args) {
        Question344 q = new Question344();
        String str = "helxlo";
        char[] s = str.toCharArray();
        long start = System.currentTimeMillis();
        q.reverseString(s);
        System.out.println(new String(s));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public void reverseString(char[] s) {
        for (int i = 0; i < s.length >> 1; i++) {
            char c = s[i];
            int h;
            s[i] = s[h = s.length - 1 - i];
            s[h] = c;
        }
    }

}

