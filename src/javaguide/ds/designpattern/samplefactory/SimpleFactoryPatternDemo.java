package javaguide.ds.designpattern.samplefactory;

/**
 * 简单工厂模式
 * <pre>
 *     意图：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
 *     主要解决：主要解决接口选择的问题。
 * </pre>
 * @author Wuxy
 * @version 1.0
 * @ClassName SimpleFactoryDemo
 * @since 2023/4/22 22:54
 */
public class SimpleFactoryPatternDemo {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape("circle");
        circle.draw();

        Shape rectangle = ShapeFactory.getShape("rectangle");
        rectangle.draw();

        Shape square = ShapeFactory.getShape("square");
        square.draw();
    }
}
