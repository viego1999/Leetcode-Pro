package javaguide.ds.designpattern.abstractfactory.colors;

import ds.designpattern.abstractfactory.Color;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Blue
 * @since 2023/4/22 23:19
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("fill blue");
    }
}
