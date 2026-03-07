package javaguide.ds.designpattern.factorymethod;

import ds.designpattern.factorymethod.impl.Square;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName SquareFactory
 * @since 2023/4/22 23:03
 */
public class SquareFactory implements ShapeFactory {
    @Override
    public Shape create() {
        return new Square();
    }
}
