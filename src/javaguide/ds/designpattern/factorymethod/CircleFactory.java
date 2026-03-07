package javaguide.ds.designpattern.factorymethod;

import ds.designpattern.factorymethod.impl.Circle;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName CircleFactory
 * @since 2023/4/22 23:00
 */
public class CircleFactory implements ShapeFactory {
    @Override
    public Shape create() {
        return new Circle();
    }
}
