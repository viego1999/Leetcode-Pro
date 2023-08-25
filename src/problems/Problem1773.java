package problems;

import java.util.List;

public class Problem1773 {
    public static void main(String[] args) {

    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0, idx = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        for (List<String> item : items) ans += item.get(idx).equals(ruleValue) ? 1 : 0;
        return ans;
    }
}
