package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2594
 * @since 2023/9/7 13:54
 */
public class Problem2594 {
    public static void main(String[] args) {

    }

    public long repairCars(int[] ranks, int cars) {
        int min = ranks[0], n = ranks.length;
        for (int rank : ranks) min = Math.min(rank, min);
        long l = 0, r = (long) min * cars * cars;
        while (l < r) {
            long m = l + r >> 1;
            int cnt = 0;
            for (int rank : ranks) cnt += Math.sqrt((double) m / rank);
            if (cnt < cars) l = m + 1;
            else r = m;
        }
        return l;
    }
}
