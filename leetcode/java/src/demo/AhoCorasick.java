package demo;

import java.util.LinkedList;
import java.util.Queue;

public class AhoCorasick {
    private AcNode root = new AcNode('/');

    public void insert(String text) {
        AcNode p = root;
        for (char ch : text.toCharArray()) {
            int index = ch - 'a';
            if (p.children[index] == null) {
                p.children[index] = new AcNode(ch);
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
        p.length = text.length();
    }


    public void buildFailurePointer() {
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            AcNode p = queue.remove();
            for (int i = 0; i < 26; ++i) {
                AcNode pc = p.children[i];
                if (pc == null) continue;
                if (p == root) {
                    pc.fail = root;
                } else {
                    AcNode q = p.fail;
                    while (q != null) {
                        AcNode qc = q.children[pc.data - 'a'];
                        if (qc != null) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }


    public void match(String text) { // text是主串

        int n = text.length();
        AcNode p = root;
        for (int i = 0; i < n; ++i) {
            int idx = text.charAt(i) - 'a';
            while (p.children[idx] == null && p != root) {
                p = p.fail; // 失败指针发挥作用的地方
            }
            p = p.children[idx];
            if (p == null) p = root; // 如果没有匹配的，从root开始重新匹配
            AcNode tmp = p;
            while (tmp != root) { // 打印出可以匹配的模式串
                if (tmp.isEndingChar) {
                    int pos = i - tmp.length + 1;
                    System.out.println("匹配起始下标" + pos + "; 长度" + tmp.length);
                }
                tmp = tmp.fail;
            }
        }
    }


    static class AcNode {
        public char data;
        public AcNode[] children = new AcNode[26]; // 字符集只包含a~z这26个字符
        public boolean isEndingChar = false; // 结尾字符为true
        public int length = -1; // 当isEndingChar=true时，记录模式串长度
        public AcNode fail; // 失败指针

        public AcNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        AhoCorasick ahoCorasick = new AhoCorasick();
        ahoCorasick.insert("how");
        ahoCorasick.insert("hi");
        ahoCorasick.insert("her");
        ahoCorasick.insert("hello");
        ahoCorasick.insert("so");
        ahoCorasick.insert("see");

        ahoCorasick.buildFailurePointer();

        ahoCorasick.match("whatareyoudoingmanhowoldareyou");
    }
}
