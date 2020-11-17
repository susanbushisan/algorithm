
public class Question12 {
    public static void main(String[] args) {
        Question12 q12 = new Question12();
        long start = System.currentTimeMillis();
        System.out.println(q12.intToRoman(3999));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public String intToRoman(int num) {
        int[] numArr = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strArr = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num != 0){
            int n = numArr[i];
            while (num >= n){
                sb.append(strArr[i]);
                num -= n;
            }

            i ++;
        }
        return sb.toString();
    }
}
