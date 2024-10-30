import demo.Trie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question208 {
    public static void main(String[] args) {
        Question208 q = new Question208();
        long start = System.currentTimeMillis();
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    static class Trie {

        private TrieNode root;

        static class TrieNode {
            char data;
            TrieNode[] child = new TrieNode[26];
            boolean isEndingChar = false;

            TrieNode(char data) {
                this.data = data;
            }
        }

        public Trie() {
            this.root = new TrieNode((char) 0);
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.child[c - 'a'] == null) {
                    node.child[c - 'a'] = new TrieNode(c);
                }
                node = node.child[c - 'a'];
            }
            node.isEndingChar = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.child[c - 'a'] == null) {
                    return false;
                }
                node = node.child[c - 'a'];
            }
            return node.isEndingChar;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.child[c - 'a'] == null) {
                    return false;
                }
                node = node.child[c - 'a'];
            }
            return true;
        }
    }


}
