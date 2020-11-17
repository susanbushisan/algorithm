3遍遍历，第一遍赋初始值，第二遍将右边比左边高的赋值左边+1，第三遍从右向左遍历，左边高的赋值右边+1
### 方法一：双向递增

~~~
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
~~~

代码实现：src/Question135.java 

时间复杂度为O(N)，空间复杂度为O(N)