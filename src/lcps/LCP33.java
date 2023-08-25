package lcps;

import java.util.PriorityQueue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName LCP33
 * @since 2023/5/21 11:19
 */
public class LCP33 {
    public static void main(String[] args) {

    }

    public int storeWater(int[] bucket, int[] vat) {
        int ans = 0x3f3f3f3f, max = 0, n = vat.length;
        for (int k : vat) max = Math.max(max, k);
        if (max == 0) return 0;
        for (int i = 1; i <= max; i++) { // 枚举倒水的次数
            int cur = i; // cur总操作数
            for (int j = 0; j < n; j++) {
                int least = (vat[j] - 1 + i) / i;
                cur += Math.max(least - bucket[j], 0); // 加水次数
            }
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
