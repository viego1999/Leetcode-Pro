package javaguide.ds.designpattern.decorator;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName ColorShapeDecorator
 * @since 2023/4/23 13:16
 */
public class ColorShapeDecorator extends ShapeDecorator {
    public ColorShapeDecorator(Shape shape) {
        super(shape);
    }

    public void draw() {
        this.shape.draw();
        System.out.println("fill color");
    }
}
