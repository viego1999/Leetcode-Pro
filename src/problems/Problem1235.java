package problems;

import java.util.Arrays;

public class Problem1235 {
    public static void main(String[] args) {

    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        int[] dp = new int[n]; // dp[i]表示在工作i时最大收益
        for (int i = 0; i < n; i++) jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        Arrays.sort(jobs, (x, y) -> x[1] - y[1]);
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], jobs[i][2]);
            int l = 0, r = i - 1;
            while (l < r) {
                int m = l + r + 1 >> 1;
                if (jobs[m][1] > jobs[i][0]) r = m - 1;
                else l = m;
            }
            if (jobs[l][1] <= jobs[i][0]) dp[i] = Math.max(dp[i], dp[l] + jobs[i][2]);
        }
        return dp[n - 1];
    }
}
