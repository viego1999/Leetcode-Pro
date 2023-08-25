package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem816 {
    public static void main(String[] args) {
        System.out.println(ambiguousCoordinates("(0123)"));
    }

    /*
        示例 1:
        输入: "(123)"
        输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
     */
    public static List<String> ambiguousCoordinates(String s) {
        List<String> ans = new ArrayList<>();
        char[] cs = s.toCharArray();
        for (int i = 2, n = cs.length; i < n - 1; i++) {
            for (String a : getStrs(cs, 1, i)) {
                for (String b : getStrs(cs, i, n - 1)) {
                    ans.add("(" + a + ", " + b + ")");
                }
            }
        }
        return ans;
    }

    public static List<String> getStrs(char[] cs, int l, int r) {
        List<String> strs = new ArrayList<>();
        // 1.添加自己本身
        if (r - l == 1 || cs[l] != '0') strs.add(new String(cs, l, r - l));
        if (r - l > 1) { // 2.添加小数点
            if (cs[r - 1] != '0') {
                strs.add(cs[l] + "." + new String(cs, l + 1, r - l - 1));
                if (cs[l] != '0') {
                    for (int i = l + 2; i < r; i++) {
                        strs.add(new String(cs, l, i - l) + "." + new String(cs, i, r - i));
                    }
                }
            }
        }
        return strs;
    }
}
