package javaguide.ds.designpattern.visitor;

/**
 * 访问者模式
 * <pre>
 *    意图：主要将数据结构与数据操作分离。
 *    主要解决：稳定的数据结构和易变的操作耦合问题。
 *    何时使用：需要对一个对象结构中的对象进行很多不同的并且不相关的操作，而需要避免让这些操作"污染"这些对象的类，使用访问者模式将这些封装到类中。
 *    如何解决：在被访问的类里面加一个对外提供接待访问者的接口。
 *    关键代码：在数据基础类里面有一个方法接受访问者，将自身引用传入访问者。
 * </pre>
 * @author Wuxy
 * @version 1.0
 * @ClassName VisitorPatternDemo
 * @since 2023/4/25 0:13
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
