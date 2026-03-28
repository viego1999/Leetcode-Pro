package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem301 {
    Set<String> ans = new HashSet<>();
    int max = 0, len = 0;

    public List<String> removeInvalidParentheses(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = 0;
        for (char c : cs) {
            if (c == '(') l++;
            else if (c == ')') r++;
        }
        max = Math.min(l, r);
        dfs(cs, "", 0, 0, 0);
        return new ArrayList<>(ans);
    }

    public void dfs(char[] cs, String cur, int l, int r, int idx) {
        if (r > l || r > max) return;
        if (idx == cs.length) {
            if (l == r && cur.length() >= len) {
                if (cur.length() > len) ans.clear();
                ans.add(cur);
                len = cur.length();
            }
            return;
        }
        if (cs[idx] == '(') {
            dfs(cs, cur + "(", l + 1, r, idx + 1);
            dfs(cs, cur, l, r, idx + 1);
        } else if (cs[idx] == ')') {
            dfs(cs, cur + ")", l, r + 1, idx + 1);
            dfs(cs, cur, l, r, idx + 1);
        } else {
            dfs(cs, cur + cs[idx], l, r, idx + 1);
        }
    }
}
