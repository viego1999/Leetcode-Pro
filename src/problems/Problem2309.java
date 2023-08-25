package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2309
 * @since 2023/1/27 22:15
 */
public class Problem2309 {

    public static void main(String[] args) {

    }

    public String greatestLetter(String s) {
        int lower = 0, upper = 0;
        for (char c : s.toCharArray()) {
            if (c >= 'a') lower |= 1 << (c - 'a');
            else upper |= 1 << (c - 'A');
        }
        for (char c = 'Z'; c >= 'A'; c--) {
            if (((lower >> (c - 'A')) & 1) == 1 && ((upper >> (c - 'A')) & 1) == 1) return String.valueOf(c);
        }
        return "";
    }

}
