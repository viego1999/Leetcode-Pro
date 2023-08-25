package problems;

public class Problem1802 {

    public static void main(String[] args) {

    }

    public int maxValue(int n, int index, int maxSum) {
        int l = 1, r = maxSum;
        while (l < r) {
            int m = l + r + 1 >> 1;
            int y1 = m - 1 - index, y2 = m - n + index;
            long t = m + m * (m - 1L) + (y1 >= 0 ? - y1 * (y1 + 1L) / 2 : -y1) + (y2 >= 0 ? -y2 * (y2 + 1L) / 2 : -y2);
            if (t > maxSum) r = m - 1;
            else l = m;
        }
        return l;
    }

}
