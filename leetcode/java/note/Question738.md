
思考

    邪教自然有邪教的做法，两种情况，数字本身就符合条件，那么返回的就是它本身，第二种就是最高位-1，然后补9得到最后的结果

### 方法一:分类讨论

~~~
    public int monotoneIncreasingDigits(int N) {
        char[] number = String.valueOf(N).toCharArray();
        int i = 1;
        while (i<number.length){
            if (number[i-1] > number[i]){
                break;
            }
            i ++;
        }
        if (i==number.length){
            return N;
        }else {
            number[i - 1] --;
            while (i<number.length){
                number[i] = '9';
                i ++;
            }
            int temp = Integer.parseInt(new String(number));
            int j = 1;
            while (j<number.length){
                if (number[j-1] > number[j]){
                    return monotoneIncreasingDigits(temp);
                }
                j ++;
            }
            return temp;
        }

    }
~~~