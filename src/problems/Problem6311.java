package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6311
 * @since 2023/3/4 23:35
 */
public class Problem6311 {
    public static void main(String[] args) {

    }

    public long coloredCells(int n) {
        long ans = 1;
        for (int i = 1; i < n; i++) {
            ans += (i + 1) * 2L + (i - 1) * 2L;
        }
        return ans;
    }
}
