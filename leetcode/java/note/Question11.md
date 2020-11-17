思考：

    面积由两个因素决定，宽和高，此处的高为两个数较小的一个。如果我缩短两个数的距离，同时还需要面积增加，那么两者的最小高度需要增加才可能实现，然后通过比较可以得到最大值。

### 方法一：双指针法

~~~
public int maxArea(int[] height) {

    int left = 0, right = height.length - 1;
    int max = Math.min(height[left], height[right]) * (height.length - 1);

    while (left != right) {
        if (height[left] <= height[right]) {
            left++;
        } else {
            right--;
        }
        max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
    }
    return max;
}
~~~

具体实现:/src/Question11.java

分析：
时间复杂度为O(n),空间复杂度为O（1）所需的额外空间为常量