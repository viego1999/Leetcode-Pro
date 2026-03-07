package javaguide.ds.designpattern.iterator;

/**
 * 迭代器模式
 * <pre>
 *    意图：提供一种方法顺序访问一个聚合对象中各个元素, 而又不需暴露该对象的内部表示。
 *    适用性：
 *      - 访问一个聚合对象的内容而无需暴露它的内部表示。
 *      - 支持对聚合对象的多种遍历。
 *      - 为遍历不同的聚合结构提供一个统一的接口(即, 支持多态迭代)。
 * </pre>
 * @author Wuxy
 * @version 1.0
 * @ClassName IteratorPatternDemo
 * @since 2023/4/24 14:27
 */
public class IteratorPatternDemo {
    public static void main(String[] args) {
        Container<String> container = new NameRepository<>(new String[]{"zhang", "san", "li", "si"});

        Iterator<String> iterator = container.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        iterator = container.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
