### 方法一：哈希表+二分查找

~~~ java
       static class TimeMap {

        Map<String, List<TsNode>> map = new HashMap<>();


        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            List<TsNode> tsNodes = map.computeIfAbsent(key, k -> new ArrayList<>());
            tsNodes.add(new TsNode(timestamp, value));
        }

        public String get(String key, int timestamp) {
            List<TsNode> tsNodes = map.get(key);
            if (tsNodes == null) {
                return "";
            }
            // 二分查找
            int left = 0, right = tsNodes.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int ts = tsNodes.get(mid).ts;
                if (ts == timestamp) {
                    return tsNodes.get(mid).value;
                } else if (ts > timestamp) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return right < 0 ? "" : tsNodes.get(right).value;
        }

        static class TsNode {
            int ts;
            String value;

            public TsNode(int ts, String value) {
                this.ts = ts;
                this.value = value;
            }
        }
    }
~~~

时间复杂度：构造函数和set为O(1),get为O(long N)

空间复杂度：O（N）

### 方法二：哈希表+红黑树

相比于二分查找，构建红黑树需要额外的性能消耗，但是可以支持删除的操作。两者时间复杂度差不多

时间复杂度：构造函数和set为O(1),get为O(long N)

空间复杂度：O（N）