package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2303
 * @since 2023/1/23 9:20
 */
public class Problem2303 {

    public static void main(String[] args) {

    }

    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        for (int i = 0, t, last = 0; i < brackets.length && income > 0; i++, income -= t) {
            t = brackets[i][0] - last;
            if (income < t) t = income;
            ans += t * brackets[i][1] / 100.;
            last = brackets[i][0];
        }
        return ans;
    }

}
