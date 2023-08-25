package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2485
 * @since 2023/6/28 0:14
 */
public class Problem2485 {
    public static void main(String[] args) {

    }

    public int pivotInteger(int n) {
        int sum = (n + 1) * n / 2, x = (int) Math.sqrt(sum);
        return x * x == sum ? x : -1;
    }
}
