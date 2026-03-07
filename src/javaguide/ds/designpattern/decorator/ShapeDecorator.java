package javaguide.ds.designpattern.decorator;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName ShapeDecorator
 * @since 2023/4/23 13:10
 */
public abstract class ShapeDecorator implements Shape {
    Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw(); // 直接调用，不做任何装饰
    }
}
