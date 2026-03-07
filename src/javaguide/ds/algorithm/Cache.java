package javaguide.ds.algorithm;

/**
 * Cache interface.
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName Cache
 * @since 2023/4/2 20:51
 */
public interface Cache<K, V> {

    void put(K key, V val);

    V get(K key);

}
