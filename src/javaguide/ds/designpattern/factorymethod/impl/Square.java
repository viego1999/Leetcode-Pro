package javaguide.ds.designpattern.factorymethod.impl;

import ds.designpattern.factorymethod.Shape;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Square
 * @since 2023/4/22 22:47
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("square");
    }
}
