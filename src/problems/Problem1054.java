package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1054
 * @since 2023/5/14 10:21
 */
public class Problem1054 {
    public static void main(String[] args) {

    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (y[1] - x[1]));
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int k = 0;
        while (!pq.isEmpty()) {
            if (pq.size() > 1) {
                int[] poll1 = pq.poll(), poll2 = pq.poll();
                barcodes[k++] = poll1[0];
                barcodes[k++] = poll2[0];
                if (--poll1[1] > 0) pq.offer(poll1);
                if (--poll2[1] > 0) pq.offer(poll2);
            } else barcodes[k++] = pq.poll()[0];
        }
        return barcodes;
    }
}
