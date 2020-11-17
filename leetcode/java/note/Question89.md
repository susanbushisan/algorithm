找路径，难道又是回溯，然后可以用位运算判断生成相邻的数

代码实现：src/Question89.java

然后看题解，大吃一惊

### 方法一：公式法
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

### 方法二：栈

~~~
    public List<Integer> grayCode(int n) {
        int length = (int)Math.pow(2, n);
        List<Integer> find = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            find.add((int)Math.pow(2,i));
        }
        Deque<Integer> stack = new ArrayDeque<>(length);
        stack.push(0);
        helper(stack,find,length);
        List<Integer> ans = new ArrayList<>(stack);
        Collections.reverse(ans);
        return ans;
    }

    private boolean helper(Deque<Integer> stack,List<Integer> find,int length){
        if (stack.size() == length){
            return true;
        }
        Integer peek = stack.peek();
        for (Integer integer : find) {
            int i = peek ^ integer;
            if (!stack.contains(i)){
                stack.push(i);
                if (helper(stack, find,length)){
                    return true;
                }
                stack.pop();
            }
        }
        return false;
    }
~~~