

public class Question10 {


    public static void main(String[] args) {
        Question10 q = new Question10();

        long start = System.currentTimeMillis();
        System.out.println(q.isMatch("aa","a*"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public boolean isMatch(String s, String p) {
        int sIndex = 0,pIndex = 0;
        return s.matches(p);
    }

}
