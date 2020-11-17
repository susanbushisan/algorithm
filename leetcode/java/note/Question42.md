有点像做过Question11题，但是仔细一想完全不同，那题数组是线，这题却有实体占位置,心生一计，可以找出盛水空间，然后减去里面占位的面积，但是这里的盛水空间有多个，构成的条件是两个边界高于中间。

### 方法一：寻找交集

我们可以分三种情况，左高右低，左低右高，左右相同。那么可以从左到右找左低右高的情况，从右到左找另两种情况，合起来就可以了。

~~~
    public int trap(int[] height) {
        if (height.length <2){
            return 0;
        }
        int area = 0,start = 0,minHeight = height[0];
        for (int i = 1; i < height.length; i++) {
            if (minHeight < height[i]){
                int w = i -start - 1;
                area += w *minHeight;
                for (int j = start + 1; j < i; j++) {
                    area -= height[j];
                }
                minHeight = height[i];
                start = i;
            }
        }
        start = height.length -1;minHeight = height[height.length -1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (minHeight <= height[i]){
                int w = start - i -1;
                area += w *minHeight;
                for (int j =  start - 1; j > i; j--) {
                    area -= height[j];
                }
                minHeight = height[i];
                start = i;
            }
        }
        return area;
    }
~~~

时间复杂度为O(n^2)


### 方法二：动态规划

- 找到数组中从下标 i 到最左端最高的条形块高度 。
- 找到数组中从下标 i 到最右端最高的条形块高度。
- 扫描数组 height 并更新答案：

~~~
public int trapDp(int[] height) {
    if (height == null || height.length < 2){
        return 0;
    }

    int ans = 0;
    int size = height.length;
    int[] leftMax = new int[size],rightMax = new int[size];
    leftMax[0] = height[0];
    rightMax[size - 1] = height[size - 1];

    for (int i = 1; i < size; i++) {
        leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        rightMax[size - 1 - i] = Math.max(height[size - 1 - i], rightMax[size - i]);
    }

    for (int i = 0; i < size; i++) {
        ans += Math.min(leftMax[i], rightMax[i]) - height[i];
    }
    return ans;
}
~~~

时间复杂度为O（n）  
空间复杂度为O(n)

### 方法三：栈

使用栈来存储条形块的索引下标
~~~
public int trapStack(int[] height) {
    int ans = 0;
    Deque<Integer> stack = new LinkedList<>();
    for (int i = 0; i < height.length; i++) {
        while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
            int top = stack.pop();
            if (stack.isEmpty())
                break;
            int distance = i - stack.peek() - 1;
            int bounded_height = Math.min(height[i], height[stack.peek()]) - height[top];
            ans += distance * bounded_height;
        }
        stack.push(i);
    }
    return ans;

}
~~~
时间复杂度为O（n）  
空间复杂度为O(n)

### 方法四：双指针

~~~
public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int ans = 0;
    int left_max = 0, right_max = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= left_max) {
                left_max = height[left];
            } else {
                ans += (left_max - height[left]);
            }
            ++left;
        } else {
            if (height[right] >= right_max) {
                right_max = height[right];
            } else {
                ans += (right_max - height[right]);
            }
            --right;
        }
    }
    return ans;
}
~~~

时间复杂度为O（n）  
空间复杂度为O(1)