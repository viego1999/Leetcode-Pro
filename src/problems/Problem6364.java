package problems;

/**
 * 类似于 Problem1994
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6364
 * @see Problem1994
 * @since 2023/2/19 10:51
 */
public class Problem6364 {
    public static void main(String[] args) {
        System.out.println(squareFreeSubsets(new int[]{3, 4, 4, 5}));
    }

    public static int squareFreeSubsets_(int[] nums) {
        int n = nums.length, mod = (int) 1e9 + 7, ans = 0;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[][] dp = new int[n + 1][1 << 10];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // 不把第 i 个数放入子集的方案数
            for (int j = 0; j < 1 << 10; j++) dp[i][j] = dp[i - 1][j];
            int num = nums[i - 1];
            boolean isSquare = false;
            // 如果是平方数
            for (int prime : primes) {
                if (num % (prime * prime) == 0) {
                    isSquare = true;
                    break;
                }
            }
            if (isSquare) continue;
            // 计算第 i 个数的质因数分解
            int state = 0;
            for (int j = 0; j < 10; j++) {
                if (num % primes[j] == 0) state |= 1 << j;
            }
            // 把第 i 个数加入子集的方案数
            for (int j = 0; j < 1 << 10; j++) {
                if ((j & state) != 0) continue; // 发生了平方数
                dp[i][j | state] = (dp[i][j | state] + dp[i - 1][j]) % mod;
            }
        }
        for (int i = 0; i < 1 << 10; i++) { // 统计每一种状态
            ans = (ans + dp[n][i]) % mod;
        }
        return (ans - 1 + mod) % mod; // 排除空集的情况
    }

    public static int squareFreeSubsets(int[] nums) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int n = nums.length, mod = (int) 1e9 + 7;
        int[] cnts = new int[31];
        long[] dp = new long[1 << 10];
        long ans = 0;
        for (int num : nums) cnts[num]++;
        dp[0] = 1;
        // 暂不考虑1做特殊处理
        for (int i = 2; i < 31; i++) {
            if (cnts[i] == 0 || i % 4 == 0 || i % 9 == 0 || i % 25 == 0) continue;
            int state = 0;
            for (int j = 0; j < 10; j++) {
                if (i % primes[j] == 0) state |= 1 << j;
            }
            for (int j = 0; j < 1 << 10; j++) {
                if ((state & j) != 0) continue;
                dp[j | state] = (dp[j | state] + dp[j] * cnts[i]) % mod;
            }
        }
        // 可以不一定有质数，故从状态0开始，但是此时可能包含了空集 dp[0] = 1
        for (int j = 0; j < 1 << 10; j++) ans = (ans + dp[j]) % mod;
        // 单独处理 1，每一个1都可以选或者不选，所以，每一个1都让ans情况翻倍
        for (int i = 0; i < cnts[1]; i++) ans = (ans * 2) % mod;
        return (int) (ans - 1 + mod) % mod; // 排除空集
    }

    public static int squareFreeSubsets__(int[] nums) {
        int mod = (int) 1e9 + 7;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29}, dp = new int[1 << 10];
        for (int num : nums) {
            boolean flag = true;
            int val = 0;
            for (int x : primes) {
                val <<= 1;
                if (num % x == 0) {
                    val |= 1;
                    if (num / x % x == 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag) continue;
            for (int j = (1 << 10) - 1; j >= 0; j--) {
                if ((val & j) != 0) continue;
                dp[j] = (dp[j] + dp[j | val] + 1) % mod;
            }
        }
        return dp[0];
    }
}
