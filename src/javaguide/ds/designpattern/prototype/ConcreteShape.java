package javaguide.ds.designpattern.prototype;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName ConcreteShape
 * @since 2023/4/23 0:07
 */
public class ConcreteShape implements Cloneable {

    public void draw() {
        System.out.println("draw");
    }

    @Override
    public ConcreteShape clone() {
        try {
            return (ConcreteShape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
