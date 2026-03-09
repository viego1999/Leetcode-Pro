package javaguide.ds.designpattern.factorymethod;

import javaguide.ds.designpattern.factorymethod.impl.Rectangle;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName RectangleFactory
 * @since 2023/4/22 23:03
 */
public class RectangleFactory implements ShapeFactory {
    @Override
    public Shape create() {
        return new Rectangle();
    }
}
