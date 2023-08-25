package offer2s;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII087
 * @since 2023/5/18 22:29
 */
public class OfferII087 {
    public static void main(String[] args) {

    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, s.toCharArray(), 0, new ArrayList<>());
        return ans;
    }

    public void backtrack(List<String> ans, char[] cs, int t, List<String> list) {
        if (t == cs.length && list.size() == 4) {
            ans.add(String.join(".", list));
            return;
        }
        if (list.size() == 3 && cs.length - t > 3) return;
        for (int i = t, num = 0; i < cs.length; i++) {
            if ((cs[t] == '0' && i > t)) break;
            num = num * 10 + (cs[i] - '0');
            if (num > 255) break;
            list.add(String.valueOf(num));
            backtrack(ans, cs, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
