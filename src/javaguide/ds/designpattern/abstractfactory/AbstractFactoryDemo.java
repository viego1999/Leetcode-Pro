package javaguide.ds.designpattern.abstractfactory;

/**
 * 抽象工厂模式（Abstract Factory Pattern）是围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。
 * <pre>
 *  意图：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 *  适用性：
 *     一个系统要独立于它的产品的创建、组合和表示时。
 *     一个系统要由多个产品系列中的一个来配置时。
 *     当你要强调一系列相关的产品对象的设计以便进行联合使用时。
 *     当你提供一个产品类库，而只想显示它们的接口而不是实现时。
 *  主要解决：主要解决接口选择的问题。
 *  何时使用：系统的产品有多于一个的产品族，而系统只消费其中某一族的产品。
 *  如何解决：在一个产品族里面，定义多个产品。
 *  关键代码：在一个工厂里聚合多个同类产品。
 * </pre>
 * @author Wuxy
 * @version 1.0
 * @ClassName AbstractFactoryDemo
 * @since 2023/4/22 23:10
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        Shape circle = shapeFactory.getShape("circle");
        circle.draw();

        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();

        Shape square = shapeFactory.getShape("square");
        square.draw();

        // ===

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color red = colorFactory.getColor("red");
        red.fill();

        Color green = colorFactory.getColor("green");
        green.fill();

        Color blue = colorFactory.getColor("blue");
        blue.fill();
    }
}
