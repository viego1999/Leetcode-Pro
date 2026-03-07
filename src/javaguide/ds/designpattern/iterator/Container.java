package javaguide.ds.designpattern.iterator;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Container
 * @since 2023/4/24 14:17
 */
public interface Container<E> {

    Iterator<E> getIterator();

}
