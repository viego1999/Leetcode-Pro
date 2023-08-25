package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2315
 * @since 2023/1/30 10:14
 */
public class Problem2315 {

    public static void main(String[] args) {

    }

    public int countAsterisks(String s) {
        int ans = 0, cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') cnt++;
            else if (c == '*' && (cnt & 1) == 0) ans++;
        }
        return ans;
    }
}
