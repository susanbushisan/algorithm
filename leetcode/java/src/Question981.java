import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class Question981 {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));
        System.out.println(timeMap.get("foo", 5));
    }

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

}

