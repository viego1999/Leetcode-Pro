package problems;

public class Problem6272 {
    public static void main(String[] args) {

    }

    public int countPartitions(int[] nums, int k) {
        long sum = 0;
        int mod = (int) 1e9 + 7;
        for (int x : nums) sum += x;
        if (sum < k * 2) return 0;
        int ans = 1;
        int[] f = new int[k];
        f[0] = 1;
        for (int x : nums) {
            ans = ans * 2 % mod;
            for (int j = k - 1; j >= x; --j)
                f[j] = (f[j] + f[j - x]) % mod;
        }
        for (int x : f)
            ans = (ans - x * 2 % mod + mod) % mod; // 保证答案非负
        return ans;
    }
}
