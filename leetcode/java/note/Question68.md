### 方法一：规则强写

~~~ java
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(words[0]);
        int count = 1;
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (sb.length() + word.length() + 1 > maxWidth) {
                if (count != 1) {
                    // 分配剩余空格
                    int remaining = maxWidth - sb.length();
                    int index = 0;
                    while (remaining > 0) {
                        if (sb.charAt(index) == ' ') {
                            while (sb.charAt(index) == ' ') {
                                index++;
                                if (index == sb.length()) {
                                    index = 0;
                                }
                            }
                            sb.insert(index, ' ');
                            remaining--;
                        }
                        index++;
                        if (index == sb.length()) {
                            index = 0;
                        }

                    }
                } else {
                    for (int j = sb.length(); j < maxWidth; j++) {
                        sb.append(' ');
                    }
                }

                // 结果加入结果集
                res.add(sb.toString());
                // 重置相关参数
                sb = new StringBuilder(word);
                count = 1;
                continue;
            }
            sb.append(' ').append(word);
            count++;
        }
        for (int i = sb.length(); i < maxWidth; i++) {
            sb.append(' ');
        }
        res.add(sb.toString());
        return res;
    }
~~~
时间复杂度O(n),数组只遍历一次
空间复杂度O(1),没有用到额外的空间