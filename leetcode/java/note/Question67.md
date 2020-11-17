思考

    既然给的是字符串，那么操作字符串就可以了。先补齐，然后从后往前位相加，最后得到的字符串反转，或者将大的数作为主数，然后加上另一个在主数的基础上改变

### 方法一：反转补0

~~~
    public String addBinary1(String a, String b) {
        int bitCount = a.length() - b.length();
        if (bitCount > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bitCount; i++) {
                sb.append("0");
            }
            b = sb.append(b).toString();
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < -bitCount; i++) {
                sb.append("0");
            }
            a = sb.append(a).toString();
        }
        int c = a.length() - 1;
        boolean step = false;
        StringBuilder stringBuilder = new StringBuilder();
        while (c >= 0) {
            int count = 0;
            if (a.charAt(c) == '1') {
                count++;
            }
            if (b.charAt(c) == '1') {
                count++;
            }
            if (step) {
                count++;
            }
            if (count >= 2) {
                step = true;
                stringBuilder.append(count - 2);
            } else {
                step = false;
                stringBuilder.append(count);
            }
            c--;
        }
        if (step) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }
~~~

具体实现:/src/Question67.addBinary1；/src/Question67.addBinary

时间复杂度O（N）
空间复杂度O（1）