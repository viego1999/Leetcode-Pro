package javaguide.ds.designpattern.abstractfactory;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName FactoryProducer
 * @since 2023/4/22 23:33
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice) {
        switch (choice) {
            case "SHAPE":
                return new ShapeFactory();
            case "COLOR":
                return new ColorFactory();
            default:
                throw new IllegalArgumentException("Invalid choice " + choice);
        }
    }

}
