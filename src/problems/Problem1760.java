package problems;

public class Problem1760 {
    public static void main(String[] args) {

    }

    // 最大值最小或者最小值最大（二分，下界定为1，上界定位最大的元素）
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = 0;
        for (int num : nums) r = Math.max(r, num);
        while (l < r) {
            int mid = l + r >> 1, ops = 0;
            for (int num : nums) ops += (num - 1) / mid;
            if (ops > maxOperations) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
