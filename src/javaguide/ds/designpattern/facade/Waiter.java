package javaguide.ds.designpattern.facade;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Waiter
 * @since 2023/4/23 13:39
 */
public class Waiter {

    public void order() {
        System.out.println("服务员接待入座、点菜");
    }

    public void serve() {
        System.out.println("服务员上菜");
    }
}
