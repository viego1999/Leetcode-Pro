package javaguide.ds.designpattern.proxy;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName ProxyImage
 * @since 2023/4/23 23:34
 */
public class ProxyImage implements Image {
    private final Image image;


    public ProxyImage(Image image) {
        this.image = image;
    }

    @Override
    public void display() {
        System.out.println("before");
        this.image.display();
        System.out.println("after");
    }
}
