思考

    核苷酸只有4种，可以用2进制进行编码为00 01 10 11 ,两位即可表示一个核苷酸，目标长度为10就可以用20位2进制表示，在一个int范围内用int表示。然后做一个长度为10移动数组，将所有编码后int第一次出现放入集合中，第二次出现就重复了，保存到结果中

具体实现:/src/Question187.java

### 方法一：状态压缩

~~~
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if (len <10){
            return new ArrayList<>();
        }
        Set<String> result = new HashSet<>();
        Set<Integer> all = new HashSet<>();
        char[] map = new char[26];
        map[0] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int key = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < 10; i++) {
            key = key << 2 | map[array[i] - 'A'];
        }
        all.add(key);
        for (int i = 10; i < len; i++) {
            key <<= 2;
            key |= map[array[i] - 'A'];
            key &= 0xfffff;
            if (all.contains(key)) {
                result.add(s.substring(i - 9, i + 1));
            } else {
                all.add(key);
            }

        }
        return new ArrayList<>(result);
    }
~~~

分析：  
时间复杂度：O(N−L)。  
空间复杂度：使用了O(N−L) 存储 hashset，因为 L=10，最终为 O(N)。

