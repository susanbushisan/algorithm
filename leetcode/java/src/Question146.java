import demo.LinkedLRU;
import struct.ListNode;
import util.ListNodeUtils;

import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Question146 {
    public static void main(String[] args) {
        Question146 q = new Question146();

        long start = System.currentTimeMillis();
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5, 5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    static class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int cacheSize;

        public LRUCache(int capacity) {
            super(capacity, 1, true);
            this.cacheSize = capacity;
        }

        public int get(int key) {
            Integer integer = super.get(key);
            return integer == null ? -1 : integer;
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > cacheSize;
        }
    }
}
