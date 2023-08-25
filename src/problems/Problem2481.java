package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2481
 * @since 2023/6/17 0:33
 */
public class Problem2481 {
    public static void main(String[] args) {

    }

    public int numberOfCuts(int n) {
        return n == 1 ? 0 : (n & 1) == 0 ? n / 2 : n;
    }
}
