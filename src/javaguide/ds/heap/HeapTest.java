package javaguide.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName HeapTest
 * @since 2023/3/17 15:39
 */
public class HeapTest {
    public static void main(String[] args) {
        // ================= max ds.heap =============
        Heap<Integer> heap = new Heap<>();
        int[] nums = {3, 1, 2, 4};
        for (int num : nums) heap.add(num);

        System.out.println("peek(): " + heap.peek());

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

        // ================= min ds.heap ===============

        heap = new Heap<>((o1, o2) -> o2 - o1);
        for (int num : nums) heap.add(num);

        System.out.println("peek(): " + heap.peek());
        System.out.println(Arrays.toString(heap.toArray()));

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) pq.add(num);

        System.out.println(Arrays.toString(pq.toArray()));
    }
}
