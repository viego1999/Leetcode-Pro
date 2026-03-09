package javaguide.ds.designpattern.abstractfactory.shapes;

import javaguide.ds.designpattern.abstractfactory.Shape;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Rectangle
 * @since 2023/4/22 22:47
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("rectangle");
    }
}
