package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1017
 * @since 2023/4/6 10:37
 */
public class Problem1017 {
    public static void main(String[] args) {

    }

    public String baseNeg2(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int t = 0, b;
        while (n > 0) {
            sb.append((b = n & 1));
            if (b == 1 && (t & 1) == 1) n += 1;
            n >>= 1;
            t++;
        }
        return sb.reverse().toString();
    }
}
