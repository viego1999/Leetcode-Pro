package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2490
 * @since 2023/6/30 9:47
 */
public class Problem2490 {
    public static void main(String[] args) {

    }

    public boolean isCircularSentence(String sentence) {
        char[] cs = sentence.toCharArray();
        for (int i = 0, n = cs.length; i < n; i++) {
            if (i > 0 && cs[i - 1] == ' ') {
                if (cs[i] != cs[i - 2]) return false;
            } else if (i == n - 1) {
                if (cs[i] != cs[0]) return false;
            }
        }
        return true;
    }
}
