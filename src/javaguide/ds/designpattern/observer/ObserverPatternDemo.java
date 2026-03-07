package javaguide.ds.designpattern.observer;

/**
 * 观察者模式
 * <pre>
 *    意图：定义对象间的一种一对多的依赖关系,当一个对象的状态发生改变时, 所有依赖于它的对象都得到通知并被自动更新。
 *    适用性：
 *      - 当一个抽象模型有两个方面, 其中一个方面依赖于另一方面。将这二者封装在独立的对象中以使它们可以各自独立地改变和复用。
 *      - 当对一个对象的改变需要同时改变其它对象, 而不知道具体有多少对象有待改变。
 *      - 当一个对象必须通知其它对象，而它又不能假定其它对象是谁。换言之, 你不希望这些对象是紧密耦合的。
 * </pre>
 * @author Wuxy
 * @version 1.0
 * @ClassName ObserverPatternDemo
 * @since 2023/4/24 17:18
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexObserver(subject);

        subject.setState(1);

        subject.setState(18);
    }
}
