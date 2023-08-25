package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1599
 * @since 2023/3/5 20:18
 */
public class Problem1599 {
    public static void main(String[] args) {

    }

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int ans = 0, cnt = 0, profit = 0, sum = 0, rest = 0, curr, t;
        for (int customer : customers) {
            rest += customer;
            sum += (t = Math.min(rest, 4));
            rest -= t;
            curr = sum * boardingCost - runningCost * ++cnt;
            if (curr > profit) {
                profit = curr;
                ans = cnt;
            }
        }
        while (rest > 0) {
            sum += (t = Math.min(rest, 4));
            rest -= t;
            curr = sum * boardingCost - runningCost * ++cnt;
            if (curr > profit) {
                profit = curr;
                ans = cnt;
            }
        }
        return profit == 0 ? -1 : ans;
    }
}
