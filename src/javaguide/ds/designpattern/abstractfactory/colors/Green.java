package javaguide.ds.designpattern.abstractfactory.colors;

import javaguide.ds.designpattern.abstractfactory.Color;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Green
 * @since 2023/4/22 23:18
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("fill green");
    }
}
