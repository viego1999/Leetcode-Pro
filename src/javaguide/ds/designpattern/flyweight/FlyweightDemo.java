package javaguide.ds.designpattern.flyweight;

/**
 * 享元模式
 * <pre>
 *    意图：运用共享技术有效地支持大量细粒度的对象。
 *    适用性：
 *       一个应用程序使用了大量的对象。
 *       完全由于使用大量的对象，造成很大的存储开销。
 *       对象的大多数状态都可变为外部状态。
 *       如果删除对象的外部状态，那么可以用相对较少的共享对象取代很多组对象。
 *       应用程序不依赖于对象标识。由于Flyweight 对象可以被共享，对于概念上明显有别的对象，标识测试将返回真值。
 *    使用场景： 1、系统有大量相似对象。 2、需要缓冲池的场景。
 * </pre>
 * @author Wuxy
 * @version 1.0
 * @ClassName FlyweightDemo
 * @since 2023/4/23 13:53
 */
public class FlyweightDemo {
    public static void main(String[] args) {
        Shape redCircle = ShapeFactory.getCircle("red");
        Shape greenCircle = ShapeFactory.getCircle("green");
        Shape redCircle2 = ShapeFactory.getCircle("red");

        System.out.println(redCircle == greenCircle); // false
        System.out.println(redCircle == redCircle2); // true
    }
}
