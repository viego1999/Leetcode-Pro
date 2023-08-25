package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem784 {
    public static void main(String[] args) {

    }

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, s.toCharArray(), 0);
        return ans;
    }

    public void backtrack(List<String> ans, char[] cs, int t) {
        if (t == cs.length) ans.add(new String(cs));
        else {
            backtrack(ans, cs, t + 1);
            boolean lower = cs[t] >= 'a' && cs[t] <= 'z', upper = cs[t] >= 'A' && cs[t] <= 'Z';
            if (lower || upper) {
                cs[t] += lower ? -32 : 32;
                backtrack(ans, cs , t + 1);
                cs[t] += lower ? 32 : -32;
            }
        }
    }
}
