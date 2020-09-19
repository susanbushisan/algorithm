public class Question70 {
    public static void main(String[] args) {
        Question70 question70 = new Question70();
        long start = System.currentTimeMillis();
        System.out.println(question70.climbStairs(45));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int climbStairs(int n) {
        if (n == 1 || n == 0){
            return 1;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i -2] + arr[i - 1];
        }
        return arr[n -1];
    }


    public int climbStairsTimeOut(int n) {
        if (n == 1 || n == 0){
            return 1;
        }
        return climbStairsTimeOut(n-2) + climbStairsTimeOut(n-1);
    }
}
