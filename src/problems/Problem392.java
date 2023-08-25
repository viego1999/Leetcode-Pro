package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem392
 * @since 2023/3/11 11:07
 */
public class Problem392 {
    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }
}
