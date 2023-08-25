package problems;

import java.util.HashSet;
import java.util.Set;

public class Problem672 {
    public static void main(String[] args) {
        Problem672 solve = new Problem672();
        System.out.println(solve.flipLights(5, 1)); // 4
        System.out.println(solve.flipLights(4, 1)); // 7
        System.out.println(solve.flipLights(2, 1000)); // 9
    }

    Set<Integer> set = new HashSet<>();

    public int flipLights(int n, int presses) {
        if (presses == 0) return 1;
        if (n > 2 && presses > 2) return 8;
        // 4, 7, 10, ... 的结果是一样的，故 k 只需取到最大为 1 ~ 5 即可
        int k = n < 3 ? n : n % 3 + 3, t = presses % 4;
        dfs(k, (1 << k) - 1, t == 0 ? 4 : t);
        return set.size();
    }

    public void dfs(int k, int s, int t) {
        if (t == 0) {
            set.add(s);
            return;
        }
        dfs(k, next(k, s, 1), t - 1);
        if (k > 1) dfs(k, next(k, s, 2), t - 1);
        dfs(k, next(k, s, 3), t - 1);
        dfs(k, next(k, s, 4), t - 1);
    }

    public int next(int k, int s, int o) {
        if (o == 1) return s ^ ((1 << (k + 1)) - 1);
        for (int i = 0; i < k; i++) {
            if ((o == 2 && (i & 1) == 1) || (o == 3 && (i & 1) == 0) || (o == 4 && i % 3 == 0)) {
                s ^= (1 << i);
            }
        }
        return s;
    }
}
