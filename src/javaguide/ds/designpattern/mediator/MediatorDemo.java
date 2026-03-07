package javaguide.ds.designpattern.mediator;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName MediatorDemo
 * @since 2023/4/24 14:47
 */
public class MediatorDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
