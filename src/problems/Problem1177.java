package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1177
 * @since 2023/6/16 9:44
 */
public class Problem1177 {
    public static void main(String[] args) {

    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] cnts = new int[n + 1];
        for (int i = 1; i <= n; i++) cnts[i] = cnts[i - 1] ^ (1 << (cs[i - 1] - 'a'));
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int l = query[0], r = query[1], k = query[2];
            int cnt = Integer.bitCount(cnts[r + 1] ^ cnts[l]);
            ans.add(cnt / 2 <= k);
        }
        return ans;
    }
}
