public class Question135 {
    public static void main(String[] args) {
        Question135 q = new Question135();
        int[] ratings = {1,0,2};

        long start = System.currentTimeMillis();
        System.out.println(q.candy(ratings));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int candy(int[] ratings) {
        if (ratings.length < 1){
            return ratings.length;
        }
        int[] candies = new int[ratings.length];
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        return sum + ratings.length;
    }

}
