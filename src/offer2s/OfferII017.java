package offer2s;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII017
 * @since 2023/4/6 19:09
 */
public class OfferII017 {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> map = new HashMap<>(), temp = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        char[] cs = s.toCharArray();
        int n = cs.length, l = 0, r = 0, ans = 0, len = n + 1;
        while (r < n) {
            temp.put(cs[r], temp.getOrDefault(cs[r++], 0) + 1);
            while (check(map, temp)) {
                if (r - l < len) {
                    ans = l;
                    len = r - l;
                }
                temp.put(cs[l], Math.max(0, temp.get(cs[l++]) - 1));
            }
        }
        return len == n + 1 ? "" : s.substring(ans, ans + len);
    }

    public boolean check(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Character c : map1.keySet()) {
            if (map1.get(c) > map2.getOrDefault(c, 0)) return false;
        }
        return true;
    }
}
