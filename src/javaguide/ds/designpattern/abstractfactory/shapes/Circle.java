package javaguide.ds.designpattern.abstractfactory.shapes;

import javaguide.ds.designpattern.abstractfactory.Shape;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Circle
 * @since 2023/4/22 22:46
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("circle");
    }
}
