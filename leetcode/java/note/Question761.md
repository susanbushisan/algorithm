就是尽可能的让1在前面会更大，根据子串的特殊性，只有1开头的子串才有意义（追求最大值）,将s细分成所有1开头的子串后排序，然后拼接成字符串

###方法一：拼接字符串

~~~
    public String makeLargestSpecial(String S) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int start = 0;
        int countOne = 0;
        for(int i = 0; i < S.length(); ++i) {
            countOne += S.charAt(i) == '1' ? 1 : -1;
            if(countOne == 0) {
                String str = S.substring(start + 1, i);
                list.add("1" + makeLargestSpecial(str) + "0");
                start = i + 1;
            }
        }
        Collections.sort(list);
        for(int i = list.size() - 1; i >= 0; --i)
            sb.append(list.get(i));
        return sb.toString();
    }
~~~

时间复杂度O(N *logN)
空间复杂度未O(N)