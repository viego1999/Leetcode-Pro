package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6290
 * @Date 2023/1/7 23:09
 */
public class Problem6290 {

    public static void main(String[] args) {
//        System.out.println(maxPower(new int[]{4, 4, 4, 4}, 0, 3));
        System.out.println(maxPower(new int[]{1, 2, 4, 5, 0}, 1, 2));
    }

    public static long maxPower(int[] stations, int r, int k) {
        long left = 1, right = (long) 5e9;
        int n = stations.length;
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            long s = 0;
            for (int j = i; j <= Math.min(n - 1, i + r); j++) {
                s += stations[j];
            }
            for (int j = i - 1; j >= Math.max(0, i - r); j--) {
                s += stations[j];
            }
            nums[i] = s;
        }
        while (left < right) {
            long m = left + right + 1 >> 1, t = 0;
            long[] temp = nums.clone();
            for (int i = 0; i < n; i++) {
                if (m > temp[i]) {
                    long sub = m - temp[i];
                    t += sub;
                    int idx = i, num = 1;
                    for (int j = i; j <= Math.min(n - 1, i + r); j++) {
                        int tn = 0;
                        for (int l = j; l <= Math.min(n - 1, j + r); l++) {
                            if (temp[l] < m) tn++;
                        }
                        for (int l = j - 1; l >= Math.max(0, j - r); l--) {
                            if (temp[l] < m) tn++;
                        }
                        if (tn > num) idx = j;
                    }
                    for (int j = i - 1; j >= Math.max(0, i - r); j--) {
                        int tn = 0;
                        for (int l = j; l <= Math.min(n - 1, j + r); l++) {
                            if (temp[l] < m) tn++;
                        }
                        for (int l = j - 1; l >= Math.max(0, j - r); l--) {
                            if (temp[l] < m) tn++;
                        }
                        if (tn > num) idx = j;
                    }
                    for (int j = idx; j <= Math.min(n - 1, idx + r); j++) {
                        temp[j] += sub;
                    }
                    for (int j = idx - 1; j >= Math.max(0, idx - r); j--) {
                        temp[j] += sub;
                    }
                }
            }
            // System.out.println("t:" + t + ", k: " + k);
            if (t > k) right = m - 1;
            else left = m;
        }
        return left;
    }
}
