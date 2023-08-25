package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6538
 * @since 2023/2/19 0:32
 */
public class Problem6538 {
    public static void main(String[] args) {

    }

    int N = (int) 1e5 + 5;
    long[] array = new long[N], tree = new long[N << 2], mark = new long[N << 2];

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        List<Long> ans = new ArrayList<>();
        int n = nums1.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            array[i + 1] = nums1[i];
            sum += nums2[i];
        }
        build(1, 1, n);
        for (int[] q : queries) {
            int o = q[0], x = q[1], y = q[2];
            if (o == 1) update(x + 1, y + 1, 1, 1, 1, n);
            else if (o == 2) sum += tree[1] * x;
            else ans.add(sum);
        }
        long[] arr = new long[ans.size()];
        for (int i = 0; i < ans.size(); i++) arr[i] = ans.get(i);
        return arr;
    }

    void push_up(int p) {
        tree[p] = tree[p << 1] + tree[p << 1 | 1];
    }

    void push_down(int p, int l, int r) {
        if (mark[p] == 0) return;
        int m = l + r >> 1;
        tree[p << 1] += (m - l + 1) - tree[p << 1];
        mark[p << 1] ^= 1;
        tree[p << 1 | 1] += (r - m) - tree[p << 1 | 1];
        mark[p << 1 | 1] ^= 1;
        mark[p] = 0;
    }

    void build(int p, int lc, int rc) {
        mark[p] = 0;
        if (lc == rc) {
            tree[p] = array[lc];
            return;
        }
        int mid = lc + rc >> 1;
        build(p << 1, lc, mid);
        build(p << 1 | 1, mid + 1, rc);
        push_up(p);
    }

    void update(int l, int r, long d, int p, int lc, int rc) {
        if (l <= lc && rc <= r) {
            tree[p] += (rc - lc + 1) - tree[p];
            mark[p] ^= 1;
            return;
        }
        push_down(p, lc, rc);
        int mid = lc + rc >> 1;
        if (l <= mid) update(l, r, d, p << 1, lc, mid);
        if (r > mid) update(l, r, d, p << 1 | 1, mid + 1, rc);
        push_up(p);
    }

    long query(int l, int r, int p, int lc, int rc) {
        if (l <= lc && rc <= r) return tree[p];
        push_down(p, lc, rc);
        int mid = lc + rc >> 1;
        long ans = 0;
        if (l <= mid) ans += query(l, r, p << 1, lc, mid);
        if (r > mid) ans += query(l, r, p << 1 | 1, mid + 1, rc);
        return ans;
    }
}
