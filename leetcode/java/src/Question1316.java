
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question1316 {

    public static void main(String[] args) {
        Question1316 q = new Question1316();
        long start = System.currentTimeMillis();
        System.out.println(q.distinctEchoSubstrings("leetcodeleetcode"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int distinctEchoSubstrings(String text) {
        char[] chars = text.toCharArray();
        int length = text.length();
        int start = 0;
        int end = 1;
        Set<String> result = new HashSet<>();
        while (start < length - 1){
            while (end < length && length - end >= end - start){
                if (chars[start] == chars[end]){
                    boolean flag = true;
                    for (int i = 0; i < end - start; i++) {
                        if (chars[start + i] != chars[end + i]){
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        result.add(new String(Arrays.copyOfRange( chars,start,2* end -start)));
                    }
                }
                end ++;
            }
            start ++;
            end = start + 1;
        }
        return result.size();
    }

    static class IntSet {
        int[] table;
        int mask;
        int size;
        IntSet(int cap){
            this.table = new int[cap];
            this.mask = cap-1;
        }

        boolean add(int val) {
            int index = val & mask;
            final int[] table = this.table;
            while (true) {
                int v = table[index];
                if (v == val)
                    return false;
                if (v == 0) {
                    size++;
                    table[index] = val;
                    return true;
                }
                index = (index + 1) & mask;
            }
        }
    }

    static final int P = 31;
    int[] pes;
    int[] hashs;
    int[] prevs;

    int init(String text) {
        final int L = text.length();
        int[] pes = new int[L];
        int[] hashs = new int[L];
        int[] prevs = new int[L];
        int[] lasts = new int[26];
        Arrays.fill(lasts, -1);
        int h = 0;
        int p = 1;
        for (int i = 0; i < L; i++) {
            int ci = text.charAt(i);
            h = h * P + ci;
            ci -= 'a';
            prevs[i] = lasts[ci];
            lasts[ci] = i;
            pes[i] = p;
            hashs[i] = h;
            p *= P;
        }
        this.pes = pes;
        this.hashs = hashs;
        this.prevs = prevs;
        return L;
    }

    public int distinctEchoSubstrings2(String text) {
        final int L = this.init(text);
        IntSet set = new IntSet(4096);
        for (int i = L - 1; i > 0; i--) {
            for (int j = prevs[i]; j >= 0; j = prevs[j]) {
                int len = i - j;
                if (i + len > L)
                    break;
                int h = hash(i, len);
                if (h == hash(j, len))
                    set.add(h);
            }
        }
        return set.size;
    }

    int hash(int off, int len) {
        return hash(this.pes, this.hashs, off, len);
    }

    static int hash(int[] pes, int[] hashs, int off, int len) {
        int h = hashs[off + len - 1];
        if (off > 0)
            h -= hashs[off - 1] * pes[len];
        return h;
    }
}
