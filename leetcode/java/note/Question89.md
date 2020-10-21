找路径，难道又是回溯，然后可以用位运算判断生成相邻的数

代码实现：src/Question89.java

然后看题解，大吃一惊
~~~java
class Solution{
    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        for(int binary = 0;binary < 1 << n; binary++){
            gray.add(binary ^ binary >> 1);
        }
        return gray;
    }
}
~~~