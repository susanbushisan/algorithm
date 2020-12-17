package demo;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private TrieNode root = new TrieNode('/');

    public void insert(String text) {
        TrieNode p = root;
        for (char ch : text.toCharArray()) {
            int index = ch - 'a';
            if (p.child[index] == null) {
                p.child[index] = new TrieNode(ch);
            }
            p = p.child[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(String pattern) {
        TrieNode p = root;
        for (char ch : pattern.toCharArray()) {
            int index = ch - 'a';
            if (p.child[index] == null) {
                return false;
            }
            p = p.child[index];
        }
        return p.isEndingChar;
    }

    public List<String> tips(String pattern) {
        TrieNode p = root;
        char[] chars = pattern.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (p.child[index] == null) {
                return new ArrayList<>();
            }
            p = p.child[index];
        }
        List<String> res = new ArrayList<>();
        if (p.isEndingChar) {
            res.add(pattern);
        }
        tipsHelper(p, pattern, res);
        return res;

    }

    private void tipsHelper(TrieNode p, String pattern, List<String> res) {
        for (int i = 0; i < p.child.length; i++) {
            TrieNode ch = p.child[i];
            if (ch != null) {
                String s = pattern + ch.data;
                if (ch.isEndingChar) {
                    res.add(s);
                }
                tipsHelper(ch, s, res);
            }
        }
    }

    static class TrieNode {
        char data;
        TrieNode[] child = new TrieNode[26];
        boolean isEndingChar = false;

        TrieNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("how");
        trie.insert("hi");
        trie.insert("her");
        trie.insert("hello");
        trie.insert("so");
        trie.insert("see");

        System.out.println(trie.tips("h"));
        System.out.println(trie.tips("her"));
    }
}
