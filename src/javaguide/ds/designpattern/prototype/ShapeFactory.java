package javaguide.ds.designpattern.prototype;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName ShapeFactory
 * @since 2023/4/23 0:08
 */
public class ShapeFactory {
    private static final ConcreteShape shape = new ConcreteShape();

    public static ConcreteShape getShape() {
        return shape.clone();
    }
}
