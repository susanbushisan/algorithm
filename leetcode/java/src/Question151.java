public class Question151 {
    public static void main(String[] args) {
        Question151 q = new Question151();
        String s = "the sky is blue";

        long start = System.currentTimeMillis();
        System.out.println(q.reverseWords(s));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int right = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isSpaceChar(c) && right != -1) {
                if (sb.length() != 0) {
                    sb.append(' ');
                }
                sb.append(s, i + 1, right + 1);
                right = -1;
            }
            if (!Character.isSpaceChar(c) && right == -1) {
                right = i;
            }
        }
        if (right != -1) {
            if (sb.length() != 0) {
                sb.append(' ');
            }
            sb.append(s, 0, right + 1);
        }
        return sb.toString();
    }

}
