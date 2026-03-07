package javaguide.ds.algorithm;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName AllTest
 * @since 2023/4/2 0:03
 */
public class AllTest {
    public static void main(String[] args) {
        Cache<Integer, Integer> lruCache = new LRUCache<>(100);
        lruCache.put(1, 1);
        System.out.println(lruCache.get(1));
    }
}
