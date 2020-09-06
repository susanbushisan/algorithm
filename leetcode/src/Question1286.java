

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 两种思路，一种是算出所有字典序值，然后迭代维护数字就行了，第二种是保留序号值，每次生成返回的对象
 */
public class Question1286 {
    public static void main(String[] args) {
        CombinationIterator iter = new CombinationIterator("aceghjlmnqsuwxy", 7);
//        System.out.println(iter.next());
//        System.out.println(iter.hasNext());
//        System.out.println(iter.next());
//        System.out.println(iter.hasNext());
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}

class CombinationIterator {

    private String characters;
    /**
     * this representative max number of combinations
     */

    private int[] current;


    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters;
        current = new int[combinationLength];
        for (int i = 0; i < current.length; i++) {
            current[i] = i;
        }
        current[combinationLength - 1]--;

    }

    private String decodeArray() {
        StringBuilder sb = new StringBuilder();
        for (int i : current) {
            sb.append(characters.charAt(i));
        }
        return sb.toString();
    }


    public String next() {
        String result = decodeArray();
        int b = current.length - 1;
        while (current[b] == characters.length() + b - current.length) {
            b--;
        }
        current[b]++;
        for (int i = 1; i < current.length - b; i++) {
            current[i + b] = current[b] + i;
        }
        return result;
    }

    public boolean hasNext() {
        return current[0] != characters.length() - current.length;
    }

}

class CombinationIterator2 {
    private int current = 0;

    /**
     * this representative max number of combinations
     */
    private List<String> chars;

    public CombinationIterator2(String characters, int combinationLength) {
        chars = new ArrayList<>();
        f(characters.toCharArray(), combinationLength, 0, 0);

    }

    public Stack<Character> stack = new Stack<>();

    private void f(char[] shu, int targ, int has, int cur) {
        if (has == targ) {
            StringBuilder stringBuffer = new StringBuilder();
            for (char c : stack) {
                stringBuffer.append(c);
            }
            chars.add(stringBuffer.toString());
            return;
        }

        for (int i = cur; i < shu.length; i++) {
            if (!stack.contains(shu[i])) {
                stack.add(shu[i]);
                f(shu, targ, has + 1, i);
                stack.pop();
            }
        }

    }

    public String next() {
        current++;
        return chars.get(current - 1);
    }

    public boolean hasNext() {
        return current != chars.size();
    }

}
