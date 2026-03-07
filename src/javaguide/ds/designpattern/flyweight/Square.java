package javaguide.ds.designpattern.flyweight;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Square
 * @since 2023/4/23 13:54
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("draw square");
    }
}
