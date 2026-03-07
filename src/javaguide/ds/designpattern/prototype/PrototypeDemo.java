package javaguide.ds.designpattern.prototype;

/**
 * 原型模式
 * <pre>
 *   意图：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 *   适用性：
 *      当要实例化的类是在运行时刻指定时，例如，通过动态装载；或者
 *      为了避免创建一个与产品类层次平行的工厂类层次时；或者
 *      当一个类的实例只能有几个不同状态组合中的一种时。建立相应数目的原型并克隆它们可能比每次用合适的状态手工实例化该类更方便一些。
 * </pre>
 * @author Wuxy
 * @version 1.0
 * @ClassName PrototypeDemo
 * @since 2023/4/23 0:05
 */
public class PrototypeDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) System.out.println(ShapeFactory.getShape());
    }
}
