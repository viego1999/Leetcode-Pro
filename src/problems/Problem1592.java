package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem1592 {
    public static void main(String[] args) {

    }

    /* 4ms
    public String reorderSpaces(String text) {
        int total = 0, n = text.length();
        String[] strs = text.trim().split("\\s+");
        for (int i = 0; i < n; i++) if (text.charAt(i) == ' ') total++;
        if (strs.length == 1) return strs[0] + " ".repeat(total);
        int num = total / (strs.length - 1), rest = total - num * (strs.length - 1);
        return String.join(" ".repeat(num), strs) + " ".repeat(rest);
    }
    */

    /* 1ms
    public String reorderSpaces(String text) {
        int total = 0, n = text.length();
        List<String> strs = new ArrayList<>();
        for (int i = 0, j = 0; j < n; j++) {
            char c1 = text.charAt(i), c2 = text.charAt(j);
            if (c2 == ' ') {
                if (c1 != ' ') strs.add(text.substring(i, (i = j)));
                total++;
            } else if (c1 == ' ') i = j;
            if (j == n - 1 && c2 != ' ') strs.add(text.substring(i, n));
        }
        if (strs.size() == 1) return strs.get(0) + " ".repeat(total);
        int num = total / (strs.size() - 1), rest = total - num * (strs.size() - 1);
        return String.join(" ".repeat(num), strs) + " ".repeat(rest);
    }
    */
}
