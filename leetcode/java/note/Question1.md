思考

暴力搜索是最好想到的，两个下标一个一个去看他们相等与否。然后想到了可以将`target-nums[i]`放入集合中，后面的某个数能匹配上这个集合中的数字的话就找到了答案

### 方法一：暴力搜索

一上来就是拿手好戏，既然是两数之和，那么2层for循环遍历，符合输出就返回

~~~
for (int i = 0; i < nums.length - 1; i++) {
    for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target){
            return new int[]{i,j};
        }
    }
}
~~~

代码实现:/src/Question1.twoSum  
时间复杂度O（n^2）空间复杂度O(1)   

### 方法二：哈希表

将`target-num[i]`作为key,`i`作为value，而哈希表的`get`方法时间复杂度近似O(1)，所以用空间换取时间是hash表最典型的应用

~~~
Map<Integer,Integer> hash = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    if (hash.containsKey(nums[i])){
        return new int[]{hash.get(nums[i]),i};
    }
    hash.put(target-nums[i],i);
}
return null;
~~~

代码实现:/src/Question1.twoSumRight
时间复杂度O（n）空间复杂度O(n)