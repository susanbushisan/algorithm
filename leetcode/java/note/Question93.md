我觉得我挺暴力的，一般找全部的解都会有一种回溯解法，但这道题分隔的数量是固定的，可以用有限的for循环来表示，暴力才是美学，于是有了我这种
4层for循环的解法

### 方法一：暴力寻找

~~~
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int length = s.length();
        if (length > 12 || length < 4){
            return ans;
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    for (int l = 1; l < 4; l++) {
                        if (i + j + k + l != length){
                            continue;
                        }
                        String n1 = s.substring(0, i);
                        String n2 = s.substring(i, i + j);
                        String n3 = s.substring(i + j, i + j + k);
                        String n4 = s.substring(i + j + k);
                        if (checkValid(n1)&&checkValid(n2)&&checkValid(n3)&&checkValid(n4)){
                            ans.add(n1 + "." + n2 + "." + n3 + "." + n4);
                        }
                    }
                }
            }
        }
        return ans;
    }


    private boolean checkValid(String str){
        if (Integer.parseInt(str) <= 255) {
            return str.charAt(0) != '0' || str.length() == 1;
        }
        return false;
    }
~~~

代码实现：src/Question93

时间复杂度，O(1)?因为循环的次数是可以计算出来的，为81次，大量的时间花在了判断上，空间复杂度为O（1）,没有花费额外的运算空间