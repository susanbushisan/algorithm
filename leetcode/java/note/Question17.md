思考

    看了第一反应就是这不就是回溯法找路径吗？仔细想了下，题目要求得到全部的组合，那拿到字符串就可以知道结果有多少个，就可以确定list的长度，后面又想到进制的除n取余法，只是这个n是动态的
    
### 方法一：回溯

比较典项的回溯问题，题目要求查找所有的可能性，那么用一个栈来记忆路径即可

~~~
public List<String> letterCombinationsBacktracking(String digits) {
    if (digits.length() == 0){
        return new ArrayList<>();
    }
    String[] dict = {
            "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    helper(digits,0,dict,sb,res);
    return res;
}

private void helper(String digits,int index,String[] dict,StringBuilder sb,List<String> res){
    if (index == digits.length()){
        res.add(sb.toString());
        return;
    }
    String op = dict[digits.charAt(index) - 50];
    for (int i = 0; i < op.length(); i++) {
        sb.append(op.charAt(i));
        helper(digits, index + 1, dict, sb, res);
        sb.deleteCharAt(index);
    }
}
~~~

分析：
时间复杂度为O（N） N为答案的个数
空间复杂度为O（digits.length()） 只用到栈来存储路径，理论上是`4*m + 3*n`但是明显有个上界为`4*digits.length()`

### 方法一：除n取余

这种方法借鉴了经典的求进制转换的问题，只是在这道题目中n是不确定的为键位的字母数量（3或者4）,我们还可以算出答案的数量，
我们假设以该键位的位置作为进制的话，0-答案数量每个数字代表一种字典组合

~~~
public List<String> letterCombinations(String digits) {
    if (digits.length() == 0){
        return new ArrayList<>();
    }
    String[] dict = {
      "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    int size = 1;
    char[] chars = digits.toCharArray();
    char[] index = new char[digits.length()];
    //算出结果的长度
    for (char aChar : chars) {
        size *= dict[aChar - 50].length();
    }
    List<String> res = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
        int c = i;
        //除n取余法
        for (int j = 0; j < digits.length(); j++) {
            String deal = dict[digits.charAt(j) - 50];
            index[j] = deal.charAt(c % deal.length());
            c = c / deal.length();
        }
        res.add(new String(index));
    }
    return res;
}
~~~

分析：
分析：
时间复杂度为O（N） N为答案的个数
空间复杂度为O（digits.length()）