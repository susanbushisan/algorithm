

import java.util.*;

public class Question784 {
    public static void main(String[] args) {
        Question784 q = new Question784();
        long start = System.currentTimeMillis();
        System.out.println(q.letterCasePermutation("a1b2C3"));
        System.out.println(System.currentTimeMillis() - start + "ms");

        start = System.currentTimeMillis();
        System.out.println(q.letterCasePermutationN("a1b2C3"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }



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


}
