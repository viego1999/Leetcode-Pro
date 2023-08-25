package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem459
 * @since 2023/2/28 10:12
 */
public class Problem459 {
    public static void main(String[] args) {

    }

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = n / 2; i > 0; i--) {
            if (n % i == 0) {
                String temp = s.substring(0, i);
                boolean flag = true;
                for (int j = i; j < n && flag; j += i) {
                    if (!s.substring(j, j + i).equals(temp)) flag = false;
                }
                if (flag) return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern_(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
