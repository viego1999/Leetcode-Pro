package javaguide.ds.designpattern.observer;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName BinaryObserver
 * @since 2023/4/24 17:21
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    protected void update() {
        System.out.println("Binary string [" + Integer.toBinaryString(this.subject.getState()) + "].");
    }
}
