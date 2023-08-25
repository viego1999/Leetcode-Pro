package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem344
 * @since 2023/8/7 23:21
 */
public class Problem344 {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int n = s.length, l = 0, r = n - 1;
        while (l < r) {
            char c = s[l];
            s[l++] = s[r];
            s[r--] = c;
        }
    }
}
