package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1156
 * @since 2023/6/3 9:55
 */
public class Problem1156 {
    public static void main(String[] args) {

    }

    public int maxRepOpt1(String text) {
        char[] cs = text.toCharArray();
        int n = cs.length, ans = 0;
        int[] cnts = new int[26];
        for (char c : cs) cnts[c - 'a']++;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && cs[j] == cs[i]) j++;
            int count = j - i;
            if (count < cnts[cs[i] - 'a'] && (j < n || i > 0)) ans = Math.max(ans, count + 1);
            int k = j + 1;
            while (k < n && cs[k] == cs[i]) k++;
            ans = Math.max(ans, Math.min(k - i, cnts[cs[i] - 'a']));
            i = j;
        }
        return ans;
    }

    public int maxRepOpt1_(String text) {
        char[] cs = text.toCharArray();
        int n = cs.length, l = 0, r = 0, ans = 0, k;
        int[] cnts = new int[26];
        for (char c : cs) cnts[c - 'a']++;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < n) {
            cnts[k = (cs[r] - 'a')]--;
            map.put(k, map.getOrDefault(k, 0) + 1);
            while (!check(map, cnts)) {
                int v = map.get(k = (cs[l] - 'a'));
                if (v == 1) map.remove(k);
                else map.put(k, v - 1);
                cnts[cs[l++] - 'a']++;
            }
            ans = Math.max(++r - l, ans);
        }
        return ans;
    }

    public boolean check(Map<Integer, Integer> map, int[] cnts) {
        if (map.size() < 2) return true;
        if (map.size() > 2) return false;
        List<Integer> keys = new ArrayList<>(map.keySet());
        return (map.get(keys.get(0)) == 1 && cnts[keys.get(1)] > 0)|| (map.get(keys.get(1)) == 1 && cnts[keys.get(0)] > 0);
    }
}
