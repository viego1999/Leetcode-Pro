package problems;

import java.util.Arrays;

public class Problem698 {
    public static void main(String[] args) {

    }

    public boolean canPartitionKSubsetsDp(int[] nums, int k) {
        int sum = 0, avg, n = nums.length;
        for (int stick : nums) sum += stick;
        if (sum % k != 0) return false;
        avg = sum / k;
        int[] dp = new int[1 << n]; // i状态下所有数的和余avg的值
        Arrays.sort(nums);
        Arrays.fill(dp, -1); // 初始化为-1，表示还未计算（不可达）状态
        dp[0] = 0;
        for (int i = 0; i < 1 << n; i++) {
            if (dp[i] < 0) continue; // -1表示该状态还未计算（不可达）
            for (int j = 0; j < n && dp[i] + nums[j] <= avg; j++) {
                if (((i >> j) & 1) == 1) continue;
                dp[i | (1 << j)] = (dp[i] + nums[j]) % avg; // 可以只更新一次（多次结果都是一样的）
            }
        }
        return dp[(1 << n) - 1] == 0;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length, m = 1 << n, sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        int[] dp = new int[m];
        Arrays.sort(nums);
        Arrays.fill(dp, -1);
        return dfs(nums, 0, 0, sum / k, dp) == 1;
    }

    public int dfs(int[] nums, int state, int sum, int avg, int[] dp) {
        if (dp[state] != -1) return dp[state];
        if (state == (1 << nums.length) - 1) return 1; // 当所有数都取完则表示必胜
        for (int i = 0; i < nums.length && sum + nums[i] <= avg; i++) {
            if (((state >> i) & 1) == 1) continue;
            // 当对手为必胜状态，则自己也是必胜状态
            if (dfs(nums, state | (1 << i), (sum + nums[i]) % avg, avg, dp) == 1)
                return dp[state] = 1;
        }
        return dp[state] = 0;
    }

    public boolean canPartitionKSubsetsBacktrack(int[] nums, int k) {
        int sum = 0, n = nums.length;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        // 数组从大到小进行遍历
        return backtrack(nums, sum / k, n - 1, new int[k]);
    }

    public boolean backtrack(int[] nums, int avg, int idx, int[] parts) {
        if (idx == -1) return true;
        for (int i = 0; i < parts.length; i++) {
            boolean duplicate = false; // 判断当前part的值在之前是否出现过
            for (int j = 0; j < i && !duplicate; j++) {
                if (parts[i] == parts[j]) duplicate = true;
            }
            // 如果当前part值之前已经遍历过则直接跳过
            if (duplicate || avg - parts[i] < nums[idx]) continue;
            parts[i] += nums[idx];
            if (backtrack(nums, avg, idx - 1, parts)) return true;
            parts[i] -= nums[idx];
        }
        return false;
    }
}
