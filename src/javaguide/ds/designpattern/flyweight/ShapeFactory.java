package javaguide.ds.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName ShapeFactory
 * @since 2023/4/23 13:54
 */
public class ShapeFactory {
    private static final Map<String, Shape> shapeMap = new HashMap<>();

    public static Shape getCircle(String color) {
        return shapeMap.computeIfAbsent(color, (key) -> new Circle(color));
    }
}
