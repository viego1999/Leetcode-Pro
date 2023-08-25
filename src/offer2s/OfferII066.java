package offer2s;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII066
 * @since 2023/5/14 12:39
 */
public class OfferII066 {
    public static void main(String[] args) {

    }

    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */
    static class MapSum {
        TreeMap<String, Integer> map = new TreeMap<>();

        /** Initialize your data structure here. */
        public MapSum() {

        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int cnt = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().startsWith(prefix)) cnt += entry.getValue();
                else if (cnt > 0) break;
            }
            return cnt;
        }
    }
}
