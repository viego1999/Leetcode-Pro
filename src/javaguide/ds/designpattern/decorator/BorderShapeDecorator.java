package javaguide.ds.designpattern.decorator;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName BorderShapeDecorator
 * @since 2023/4/23 13:13
 */
public class BorderShapeDecorator extends ShapeDecorator {
    public BorderShapeDecorator(Shape shape) {
        super(shape);
    }

    public void draw() {
        System.out.println("top border");
        this.shape.draw();
        System.out.println("bottom border");
    }
}
