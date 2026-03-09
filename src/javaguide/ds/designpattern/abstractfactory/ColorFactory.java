package javaguide.ds.designpattern.abstractfactory;

import javaguide.ds.designpattern.abstractfactory.colors.Blue;
import javaguide.ds.designpattern.abstractfactory.colors.Green;
import javaguide.ds.designpattern.abstractfactory.colors.Red;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName ColorFactory
 * @since 2023/4/22 23:28
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        switch (colorType) {
            case "red":
                return new Red();
            case "green":
                return new Green();
            case "blue":
                return new Blue();
            default:
                throw new RuntimeException("Invalid colorType " + colorType);
        }
    }
}
