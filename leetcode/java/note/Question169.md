思考

    第一想法，统计，然后返回最大出现次数的数，没给出数的返回，那么用Map进行处理好了

    第二想法，既然超过一半，那么排序后，数组的中位数一定是答案

    参考别的思路，投票，超过一半数

代码实现 src/Question169.majorityElement,src/Question169.majorityElementSort,src/Question169.majorityElementVote

复杂度分析  
- 第一种 时间复杂度为O(N),空间复杂度为O（N）  
- 第二种 时间复杂度为O（NlogN）,空间复杂度为O(logN)栈空间使用  
- 第三种 时间复杂度为O(N),空间复杂度为O（1）

### 方法一：统计

~~~
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.merge(num,1, Integer::sum);
        }
        int maxCount = 0,v = nums[0];
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > maxCount){
                maxCount = entry.getValue();
                v = entry.getKey();
            }
        }
        return v;
    }
~~~

时间复杂度为O(N),空间复杂度为O（N）  

### 方法二：排序中位数

~~~
    public int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
~~~
 时间复杂度为O（NlogN）,空间复杂度为O(logN)栈空间使用
 
### 方法三：投票选举

~~~
    public int majorityElementVote(int[] nums) {
        int voter = nums[0];
        int ticket = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (voter == num){
                ticket ++;
            }else {
                ticket --;
                if (ticket == 0){
                    voter = num;
                    ticket = 1;
                }
            }
        }
        return voter;
    }
~~~