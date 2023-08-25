package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2496
 * @since 2023/6/23 22:55
 */
public class Problem2496 {
    public static void main(String[] args) {

    }

    public int maximumValue(String[] strs) {
        int ans = 0;
        for (String str : strs) {
            int t = 0;
            for (char c : str.toCharArray()) {
                if (Character.isLetter(c)) {
                    t = str.length();
                    break;
                } else t = t * 10 + (c - '0');
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }
}
