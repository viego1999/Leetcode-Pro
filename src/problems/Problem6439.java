package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6439
 * @since 2023/5/21 11:18
 */
public class Problem6439 {
    public static void main(String[] args) {

    }

    public int minLength(String s) {
        String t = s;
        while (true) {
            String str = t;
            t = t.replace("AB", "");
            t = t.replace("CD", "");
            if (t.equals(str)) break;
        }
        return t.length();
    }
}
