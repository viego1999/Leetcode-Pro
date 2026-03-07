package javaguide.ds.designpattern.decorator;

/**
 * 装饰器模式
 * <pre>
 *    意图：动态地给一个对象添加一些额外的职责。就增加功能来说，Decorator 模式相比生成子类更为灵活。
 *    适用性：
 *       在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
 *       处理那些可以撤消的职责。
 *       当不能采用生成子类的方法进行扩充时。一种情况是，可能有大量独立的扩展，为支持每一种组合将产生大量的子类，使得子类数目呈爆炸性增长。另一种情况可能是因为类定义被隐藏，或类定义不能用于生成子类。
 * </pre>
 * @author Wuxy
 * @version 1.0
 * @ClassName DecoratorDemo
 * @since 2023/4/23 13:10
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape shape = new ColorShapeDecorator(new BorderShapeDecorator(new Circle()));
        shape.draw();
    }
}
