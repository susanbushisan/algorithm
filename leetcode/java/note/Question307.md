### 方法一：实现需求
根据题目要求实现需求

~~~java
     class NumArray {

        private int[] nums;
        
        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public void update(int index, int val) {
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
            return sum;
        }
    }
~~~
构造方法时间复杂度O(1)  
update 方法时间复杂度O(1)  
sumRange 方法时间复杂度 O(n)，取决于left和right的大小 

空间复杂度 O(1)，除了原数组不需要额外的存储数据

### 方法二：分块处理
方法一超时，看起来是sumRange方法的时间复杂度过高。可以想办法建立索引，但是建立全局和索引的话update的代价
太大了。所以考虑分块处理

~~~java
     class NumArray {

        private int[] nums;

        private int size;

        private int[] sum;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.size = (int) Math.sqrt(nums.length);
            sum = new int[(nums.length + size) / size];
            for (int i = 0; i < nums.length; i++) {
                sum[i / size] += nums[i];
            }
        }

        public void update(int index, int val) {
            sum[index / size] += val - nums[index];
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            int b1 = left / size;
            int b2 = right / size;
            if (b1 == b2) {
                int sum = 0;
                for (int j = left; j <= right; j++) {
                    sum += nums[j];
                }
                return sum;
            }
            int i1 = left % size;
            int i2 = right % size;
            int count = 0;
            for (int i = i1; i < size; i++) {
                count += nums[b1 * size + i];
            }
            for (int i = 0; i <= i2; i++) {
                count += nums[b2 * size + i];
            }
            for (int i = b1 + 1; i < b2; i++) {
                count += sum[i];
            }
            return count;
        }
    }
~~~
构造方法时间复杂度O(n)  
update 方法时间复杂度O(根号n)  
sumRange 方法时间复杂度 O(根号n)

空间复杂度 O(根号n)，存储块结果数据

