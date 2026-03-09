package javaguide.ds.designpattern.abstractfactory;

import javaguide.ds.designpattern.abstractfactory.shapes.Circle;
import javaguide.ds.designpattern.abstractfactory.shapes.Rectangle;
import javaguide.ds.designpattern.abstractfactory.shapes.Square;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName SampleFactory
 * @since 2023/4/22 22:44
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
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

    @Override
    public Color getColor(String colorType) {
        return null;
    }
}
