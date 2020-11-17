思路：  
回文一共有两种实现，其一是aba型，其二是abba型，其中abbba算是第一种，这个我们可以先找中心点然后向两边扩展区判断子串是否是回文

### 方法一：中心扩展

~~~
public String longestPalindrome(String s) {
    int start = 0;
    int len = 0;
    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length;) {
        int[] res = expand(arr, i);
        i = res[2];
        if (len < res[1]) {
            len = res[1];
            start = res[0];
        }
    }
    return s.substring(start, start + len);
}

private int[] expand(char[] arr, int center) {
    int left = center;
    int right = center + 1;
    while (right < arr.length && arr[left] == arr[right]) {
        right++;
    }
    center = right;
    left--;
    while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
        left--;
        right++;
    }
    return new int[] { left + 1, right - left - 1, center };
}
~~~

具体实现:/src/Question5.java


- 时间复杂度为O(n^2)
- 空间复杂度为O（1）