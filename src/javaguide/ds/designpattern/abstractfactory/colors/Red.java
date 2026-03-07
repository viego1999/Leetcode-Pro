package javaguide.ds.designpattern.abstractfactory.colors;

import ds.designpattern.abstractfactory.Color;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Red
 * @since 2023/4/22 23:17
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("fill red");
    }
}
