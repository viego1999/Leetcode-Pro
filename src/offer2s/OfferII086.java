package offer2s;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII086
 * @since 2023/5/18 22:03
 */
public class OfferII086 {
    public static void main(String[] args) {

    }

    public String[][] partitionDp(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = cs[j] == cs[i] && (j + 1 > i - 1 || dp[j + 1][i - 1]);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans, cs, 0, new ArrayList<>(), dp);
        String[][] strs = new String[ans.size()][];
        for (int i = 0; i < strs.length; i++) strs[i] = ans.get(i).toArray(new String[0]);
        return strs;
    }

    public void backtrack(List<List<String>> ans, char[] cs, int t, List<String> list, boolean[][] dp) {
        if (t == cs.length) ans.add(new ArrayList<>(list));
        for (int i = t; i < cs.length; i++) {
            if (dp[t][i]) {
                String str = new String(cs, t, i - t + 1);
                list.add(str);
                backtrack(ans, cs, i + 1, list, dp);
                list.remove(list.size() - 1);
            }
        }
    }

    public String[][] partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans, s.toCharArray(), 0, new ArrayList<>());
        String[][] strs = new String[ans.size()][];
        for (int i = 0; i < strs.length; i++) strs[i] = ans.get(i).toArray(new String[0]);
        return strs;
    }

    public void backtrack(List<List<String>> ans, char[] cs, int t, List<String> list) {
        if (t == cs.length) ans.add(list);
        for (int i = t; i < cs.length; i++) {
            if (check(cs, t, i)) {
                String str = new String(cs, t, i - t + 1);
                list.add(str);
                backtrack(ans, cs, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean check(char[] cs, int l, int r) {
        while (l < r) {
            if (cs[l++] != cs[r--]) return false;
        }
        return true;
    }
}
