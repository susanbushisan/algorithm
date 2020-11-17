这题挺有意思的，题目限制了时间复杂度为O(n)空间复杂度为O(1)，这就是最大的难点

通常的解法有三种  

### 方法一：从小找到大

- 从1开始找数组中存不存在1，如果存在就加1再从来，如果不存在就返回这个数。但是此时的时间复杂度为O（N^2）,空间复杂度为O(1)
~~~
i = 1;
while(i<=num.length){
    for(int j = 0; j < num.length; j ++){
        if(i == num[j]){
            i ++;
            continue;
        }
    }
    break;
}
return i;
~~~

### 方法二：哈希表缓存

- 将数组放在哈希表中，然后从1自增看书否存在,这样时间复杂度为O(N),时间复杂度为O(N)


### 方法三：排序后遍历
- 将数组排序，然后遍历数组，但排序需要的时间复杂度为O(N*logN)，遍历时间复杂度为O(N),空间复杂度为O(1)

貌似都不符合，那么只能找方法的变种

### 方法四：排除干扰项

在数组中小于0和大于num.length的是不影响结果的

- 我们将数组中所有小于等于 0 的数修改为 N+1；

- 我们遍历数组中的每一个数 x，它可能已经被打了标记，因此原本对应的数为 ∣x∣，∣x∣−1 个位置的数添加一个负号。注意如果它已经有负号，不需要重复添加；

- 在遍历完成之后，如果数组中的每一个数都是负数，那么答案是 N+1，否则答案是第一个正数的位置加 1。

~~~
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] < 1){
                nums[i] = length + 1;
            }
        }
        for (int i = 0; i < length; i++) {
            int x = Math.abs(nums[i]);
            if (x > 0 && x <= length){
                if (nums[x - 1] > 0){
                    nums[x - 1] = - nums[x - 1];
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0){
                return i + 1;
            }
        }
        return length + 1;
    }
~~~

妙啊,时间复杂度为O（N），空间复杂度为O(1)
代码实现：src/Question41.java