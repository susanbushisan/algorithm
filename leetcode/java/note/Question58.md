思考

    反着来就可以了，先判断字符串是否包含字符，不包含返回0，然后从后往前招第一个非空白字符，然后继续找第一个空白字符，两者的差即为答案

### 方法一：反向查找

~~~
    public int lengthOfLastWord(String s) {
        int strLen = s.length();
        if (strLen == 0){
            return 0;
        }
        boolean flag = false;
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                flag = true;
            }
        }
        if (!flag){
            return 0;
        }
        int endPoint,startPoint;
        while (Character.isWhitespace(s.charAt(strLen - 1))){
            strLen --;
        }
        endPoint = strLen;
        while (strLen > 0 &&!Character.isWhitespace(s.charAt(strLen - 1))){
            strLen --;
        }
        startPoint = strLen;
        return endPoint - startPoint;
    }
~~~


具体实现:/src/Question58.java

时间复杂度为O（N）
空间复杂度为O（1）