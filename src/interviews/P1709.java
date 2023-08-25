package interviews;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class P1709 {
    public static void main(String[] args) {

    }

    public int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        pq.offer(1);
        set.add(1);
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = pq.poll();
            for (int factor : factors) {
                if (ans > Integer.MAX_VALUE / factor) continue;
                int next = ans * factor;
                if (set.add(next)) pq.offer(next);
            }
        }
        return ans;
    }
}
