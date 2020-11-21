### 方法一：二分法

~~~
    public int mySqrt(int x) {
        int high = x,low = 0;
        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if ((long)mid * mid <= x ){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low + ((high - low) >> 1);
    }
~~~

时间复杂度为O(logN)，空间复杂度为O(1)

### 方法二：牛顿迭代

~~~
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

~~~

时间复杂度：O(logx)，即为二分查找需要的次数。

空间复杂度：O(1)。