package javaguide.ds.designpattern.proxy;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName RealImage
 * @since 2023/4/23 23:32
 */
public class RealImage implements Image {
    @Override
    public void display() {
        System.out.println("display image.");
    }
}
