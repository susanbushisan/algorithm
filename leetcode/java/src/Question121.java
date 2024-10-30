public class Question121 {


    public static void main(String[] args) {
        Question121 q = new Question121();
        int[] price = {7,1,5,3,6,4};
        long start = System.currentTimeMillis();
        System.out.println(q.maxProfit(price));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (minPrice >= price) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

}
