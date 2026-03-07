package javaguide.ds.designpattern.iterator;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Iterator
 * @since 2023/4/24 14:17
 */
public interface Iterator<E> {

    boolean hasNext();

    E next();

}
