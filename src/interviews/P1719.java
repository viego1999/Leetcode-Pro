package interviews;

public class P1719 {
    public static void main(String[] args) {

    }

    // 等差数列求和
    public int[] missingTwo(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) sum += num;
        // ts = x + y, mid 为缺失的两个数x、y的中间数
        int ts = (n + 2) * (n + 3) / 2 - sum, mid = ts / 2;
        sum = 0;
        for (int num : nums) if (num <= mid) sum += num; // 统计[1-mid]的和
        int x = mid * (mid + 1) / 2 - sum; // 求x
        return new int[] {x, ts - x};
    }

    public int[] missingTwo_(int[] nums) {
        int n = nums.length, idx = 0, a = 1, b = 1;
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            int t = Math.abs(nums[i]) - 1;
            if (t < n) nums[t] = -nums[t];
            else if (t == n) a = 0;
            else b = 0;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) res[idx++] = i + 1;
        }
        if (a == 1) res[idx++] = n + 1;
        if (b == 1) res[idx] = n + 2;
        return res;
    }
}
