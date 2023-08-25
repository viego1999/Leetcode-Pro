package offer2s;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII016
 * @since 2023/4/6 18:25
 */
public class OfferII016 {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), l = 0, r = 0, i, ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        while (r < n) {
            map.put(cs[r], map.getOrDefault(cs[r], 0) + 1);
            while (map.getOrDefault(cs[r], 0) > 1) {
                int v = map.get(cs[l]);
                if (v == 1) map.remove(cs[l]);
                else map.put(cs[l], v - 1);
                l++;
            }
            ans = Math.max(ans, ++r - l);
        }
        return ans;
    }
}
