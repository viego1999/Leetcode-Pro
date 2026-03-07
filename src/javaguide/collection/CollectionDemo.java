package javaguide.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName CollectionDemo
 * @since 2023/6/4 21:43
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection<Object> objects = new ArrayList<>();
        objects.add(new Object());
        objects.forEach((o -> {
            System.out.println("o: " + o);
        }));
    }
}
