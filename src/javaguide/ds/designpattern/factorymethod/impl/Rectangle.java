package javaguide.ds.designpattern.factorymethod.impl;

import javaguide.ds.designpattern.factorymethod.Shape;

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
