package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1093
 * @since 2023/5/27 14:21
 */
public class Problem1093 {
    public static void main(String[] args) {

    }

    public double[] sampleStats(int[] count) {
        int total = Arrays.stream(count).sum();
        int maxmum = 0, minmum = 0x3f3f3f3f, mode = 0, maxcnt = 0, cnt = 0;
        int left = (total + 1) / 2, right = (total + 2) / 2;
        double mean, median = 0.;
        long sum = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                maxmum = i;
                if (minmum == 0x3f3f3f3f) minmum = i;
            }
            sum += (long) count[i] * i;
            if (count[i] > maxcnt) {
                mode = i;
                maxcnt = count[i];
            }
            if (cnt < left && cnt + count[i] >= left) median += i;
            if (cnt < right && cnt + count[i] >= right) median += i;
            cnt += count[i];
        }
        mean = (double) sum / total;
        median /= 2.;
        return new double[]{minmum, maxmum, mean, median, mode};
    }
}
