package javaguide.ds.designpattern.iterator;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName NameRepository
 * @since 2023/4/24 14:18
 */
public class NameRepository<E> implements Container<E> {
    private E[] names;


    public NameRepository(E[] names) {
        this.names = names;
    }

    @Override
    public Iterator<E> getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator<E> {
        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public E next() {
            return names[index++];
        }
    }
}
