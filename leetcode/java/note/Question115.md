最后答案求的是个数，那么这道题应该有DP解法
### 方法一：动态规划

~~~
    public int numDistinct(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        if (tLength > sLength){
            return 0;
        }
        if (s.equals(t)){
            return 1;
        }
        int[][] dp = new int[sLength][tLength];
        for (int i = 0; i < sLength ; i++) {
            for (int j = 0; j <= Math.min(tLength - 1, i); j++) {
                if (j == i) {
                    int temp = Objects.equals(s.substring(0, i + 1), t.substring(0, i + 1)) ? 1 : 0;
                    dp[i][j] = temp;
                    continue;
                }
                if (j == 0) {
                    int temp = s.charAt(i) == t.charAt(0) ? 1 : 0;
                    dp[i][0] = dp[i - 1][0] + temp;
                    continue;
                }
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[sLength - 1][tLength - 1];
    }
~~~

当t的长度大于s的长度时候，答案一定为0，在dp数组中应该以x=y为限制条件求解

转移方程根据数据找规律终于得到了  

- 如果在x和y相等的时候答案只有0或者1，0代表s和t在前x个是相等的
- 如果是在y=0的时候，值应该等于`dp[x-1][0]`的值加上s新增的一个是否和t的第一个相等
- 如果s的第x个是否和t的y个相等，那么此处的值就为`dp[x-1][y] + dp[x-1][y-1]`