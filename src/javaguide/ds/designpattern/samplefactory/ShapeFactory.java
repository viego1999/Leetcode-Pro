package javaguide.ds.designpattern.samplefactory;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName SampleFactory
 * @since 2023/4/22 22:44
 */
public class ShapeFactory {


    public static Shape getShape(String shapeType) {
        switch (shapeType) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "square":
                return new Square();
            default:
                throw new RuntimeException("Invalid shapeType " + shapeType);
        }
    }
}
