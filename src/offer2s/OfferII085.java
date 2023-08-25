package offer2s;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII085
 * @since 2023/5/18 21:41
 */
public class OfferII085 {
    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, n, n, "");
        return ans;
    }

    public void backtrack(List<String> ans, int lc, int rc, String str) {
        if (lc > rc) return;
        if (lc == rc && lc == 0) {
            ans.add(str);
            return;
        }
        if (lc > 0) backtrack(ans, lc - 1, rc, str + "(");
        if (rc > 0) backtrack(ans, lc, rc - 1, str + ")");
    }
}
