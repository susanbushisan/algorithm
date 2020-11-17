思考

    只有字母需要变换，那就先把字母标记，然后就是一个组合问题了，最后结果的数量为2^S.length()个解

### 方法一：字典序

~~~
    List<Entry> current = new ArrayList<>();
    String S ;
    public List<String> letterCasePermutation(String S) {
        this.S = S;

        for (int i = 0; i < S.toCharArray().length; i++) {
            if (Character.isLetter(S.charAt(i))) {
                current.add(new Entry(i, false));
            }
        }
        String[] res = new String[(int) Math.pow(2, current.size())];
        for (int i = 0; i < res.length; i++) {
            res[i] = next();
        }
        System.out.println(current.size());
        return Arrays.asList(res);
    }

    private String next() {
        char[] chars = S.toCharArray();
        current.forEach(e -> {
            if (e.status) {
                chars[e.key] = Character.isUpperCase(chars[e.key]) ? Character.toLowerCase(chars[e.key]) : Character.toUpperCase(chars[e.key]);
            }
        });
        for (int i = current.size() - 1; i >= 0; i--) {
            if (!current.get(i).status) {
                current.get(i).status = true;
                for (int j = current.size() - 1; j > i; j--) {
                    current.get(j).status = false;
                }
                break;
            }
        }

        return new String(chars);
    }

    static class Entry {
        int key;
        boolean status;

        public Entry(int key, boolean status) {
            this.key = key;
            this.status = status;
        }
    }
~~~


时间复杂度和空间复杂度都为O(2^N∗N)

### 方法二：回溯法

~~~
    public List<String> letterCasePermutationN(String S) {
        List<String> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        char[] chars = S.toLowerCase().toCharArray();

        for (int i = 0; i < S.toCharArray().length; i++) {
            if (Character.isLetter(S.charAt(i))) {
                current.add(i);
            }
        }
        helper(0, current, chars, ans);
        return ans;
    }

    private void helper(int index, List<Integer> current, char[] chars, List<String> ans) {
        if (index == current.size()) {
            ans.add(new String(chars));
            return;
        }
        helper(index + 1, current, chars, ans);
        boolean f = Character.isLowerCase(current.get(index));
        if (f) {
            chars[current.get(index)] += 32;
        } else {
            chars[current.get(index)] -= 32;
        }
        helper(index + 1, current, chars, ans);
        if (f) {
            chars[current.get(index)] -= 32;
        } else {
            chars[current.get(index)] += 32;
        }

    }
~~~

时间复杂度为O(2^M) M代表字母的个数
空间复杂度为O（N + M） N代表字母的长度