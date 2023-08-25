package problems;


public class Problem1824 {

    public static void main(String[] args) {
        /**/
    }

    public int minSideJumpsGreedy(int[] obstacles) {
        int n = obstacles.length, cur = 2, cnt = 0, step = 0;
        while (step < n - 1) {
            if (obstacles[step + 1] != cur) {
                step++;
                continue;
            }
            int one = (one = (cur + 1) % 3) == 0 ? 3 : one, two = (two = (cur + 2) % 3) == 0 ? 3 : two, i = step, j = step;
            while (i < n && obstacles[i] != one) i++;
            while (j < n && obstacles[j] != two) j++;
            cur = i > j ? one : two;
            step = Math.max(i, j) - 1;
            cnt++;
        }
        return cnt;
    }

    public int minSideJumps_(int[] obstacles) {
        int n = obstacles.length, max = 0x3f3f3f3f;
        int[] dp = new int[3]; // 到达i处跑到j时的最少跳跃数
        dp[0] = dp[2] = 1;
        for (int i = 1; i < n; i++) {
            int curr = obstacles[i] - 1, min = max;
            // 先更新所有跑道到i点处的跳跃步数，记录最小值
            for (int j = 0; j < 3; j++) {
                if (curr == j) dp[j] = max; // 此处有障碍
                min = Math.min(min, dp[j]);
            }
            // 然后用最小值更新可以跳跃到的其它跑道的最小值
            for (int j = 0; j < 3; j++) {
                if (curr != j) dp[j] = Math.min(dp[j], min + 1); // 如果当前跑道没有障碍，则可以从其他两个跑道跨越到当前跑道走一步
            }
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length, max = 0x3f3f3f3f;
        int[][] dp = new int[n][3]; // 到达i处跑到j时的最少跳跃数
        dp[0][0] = dp[0][2] = 1;
        for (int i = 1; i < n; i++) {
            int prev = obstacles[i - 1] - 1, curr = obstacles[i] - 1;
            for (int j = 0; j < 3; j++) {
                if (curr == j) dp[i][j] = max; // 此处有障碍
                else {
                    dp[i][j] = dp[i - 1][j]; // 直接从当前跑道上一步走过来
                    // 如果当前跑道前一步没有障碍，则可以从其他两个跑道跨越到当前跑道走一步
                    if (prev != j) dp[i][j] = Math.min(dp[i][j], dp[i - 1][(j + 1) % 3] + 1);
                    if (prev != j) dp[i][j] = Math.min(dp[i][j], dp[i - 1][(j + 2) % 3] + 1);
                }
            }
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

}
