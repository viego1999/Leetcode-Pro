package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2240
 * @since 2023/9/1 21:47
 */
public class Problem2240 {
    public static void main(String[] args) {

    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for (int i = 0; ; i++) {
            int rest = total - cost1 * i;
            if (rest < 0) break;
            ans += rest / cost2 + 1;
        }
        return ans;
    }
}
