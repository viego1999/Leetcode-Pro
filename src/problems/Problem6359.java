package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6359
 * @since 2023/2/18 23:34
 */
public class Problem6359 {
    public static void main(String[] args) {

    }

    public int minMaxDifference(int num) {
        String s = String.valueOf(num), s1 = s, s2 = s;
        for (char c : s.toCharArray()) {
            if (c != '9') {
                s1 = s.replace(c, '9');
                break;
            }
        }
        for (char c : s.toCharArray()) {
            if (c != '0') {
                s2 = s.replace(c, '0');
                break;
            }
        }
        return Integer.parseInt(s1) - Integer.parseInt(s2);
    }
}
