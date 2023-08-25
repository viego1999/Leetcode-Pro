package problems;

public class Problem6250 {
    public static void main(String[] args) {
        System.out.println(bestClosingTime("YYNY"));
        System.out.println(bestClosingTime("YYYY"));
        System.out.println(bestClosingTime("NNNNN"));
    }

    public static int bestClosingTime(String customers) {
        char[] cs = customers.toCharArray();
        int n = cs.length, val, ans = 0;
        int[] sums = new int[n + 1];
        sums[0] = cs[0] == 'Y' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + (cs[i] == 'Y' ? 1 : 0);
        }
        val = sums[n] = sums[n - 1];
        for (int i = 1; i <= n; i++) {
            int a = (i - sums[i - 1]) + (sums[n - 1] - sums[i - 1]);
            if (a < val) {
                val = a;
                ans = i;
            }
        }
        return ans;
    }
}
