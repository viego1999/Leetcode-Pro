package javaguide.ds.designpattern.abstractfactory;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName AbstractFactory
 * @since 2023/4/22 23:16
 */
public abstract class AbstractFactory {

    public abstract Shape getShape(String shapeType);

    public abstract Color getColor(String colorType);

}
