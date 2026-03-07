package javaguide.ds.designpattern.flyweight;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Circle
 * @since 2023/4/23 13:54
 */
public class Circle implements Shape {
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("draw " + color + " circle");
    }
}
