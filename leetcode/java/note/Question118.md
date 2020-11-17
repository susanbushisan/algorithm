以前写过数组的写法，这个区别只是用集合的写法写一遍就好

### 方法一：限定边界

~~~
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j <= i; j++) {
                if (j == i){
                    temp.add(1);
                    break;
                }
                List<Integer> pre = ans.get(ans.size() - 1);
                temp.add(pre.get(j - 1)+pre.get(j));
            }
            ans.add(temp);
        }
        return ans;
    }
~~~

代码实现：src/Question118.java

时间复杂度为O（n^2），空间复杂度为O（1）