public class Question168 {
    public static void main(String[] args) {
        Question168 question168 = new Question168();
        long start = System.currentTimeMillis();
        System.out.println(question168.convertToTitle(28));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 就是你了，除n取余法
     */
    public String convertToTitle(int n) {
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            char c = (char) ('A' + (n-1) % 26);
            ans.append(c);
            n = (n-1)/26;
        }
        return ans.reverse().toString();
    }

}
