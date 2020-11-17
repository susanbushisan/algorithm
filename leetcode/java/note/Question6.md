思路：

可以通过高度h构建` h*s.length`的二维数组，然后循环遍历字符按照Z型往二维数组中添加，最后遍历出来得到答案。  
 此时可以不考虑二维数组的横坐标，h为1的时候直接返回原字符串，h = 2 时只要构造`h *（s * length / 2）`数组即可满足条件。

### 方法一：按行构建

~~~
public String convert(String s, int numRows) {
    if (numRows == 1 )return s;
    StringBuilder[] chars = new StringBuilder[numRows];
    for (int i = 0; i <numRows ; i++) {
        chars[i] = new StringBuilder();
    }
    int i = 0;
    boolean flag = true;
    for (int j = 0; j < s.length(); j++) {
        chars[i].append(s.charAt(j));
        i = flag ? i + 1: i - 1;
        if (i == numRows - 1){
            flag = false;
        }else if (i == 0){
            flag = true;
        }
    }
    StringBuilder result = new StringBuilder();
    for (int j = 0; j < numRows; j++) {
        result.append(chars[j].toString());
    }
    return result.toString();
}
~~~

具体实现:/src/Question6.java


- 时间复杂度为O(n)
- 空间复杂度为O（n）

### 方法二：按行访问

既然高度h能确定，那么下一个数的位置也是确定的。

对于所有整数 k，

1. 首行在的位置应该为`k（2*h - 2）`
2. 尾行在的位置为`k（2*h - 2） + h -1 `，首行的位置`+h-1`
3. 中间所在的位置为`k（2*h - 2）+i` 或者`(k+1)（2*h - 2）-i`

~~~
public String convertFind(String s, int numRows) {
    if (numRows == 1) return s;
    StringBuilder result = new StringBuilder();
     int n = s.length();
    int cycleLen = 2 * numRows - 2;
    for (int i = 0; i < numRows; i++) {
        for (int j = 0; j + i < n; j += cycleLen) {
            result.append(s.charAt(i + j));
            if (i != 0 && i != numRows - 1 && j + cycleLen - i < n){
                result.append(s.charAt(j + cycleLen - i));
            }
        }
    }
     return result.toString();
}
~~~

- 时间复杂度：O(n)
- 空间复杂度：O(n)
