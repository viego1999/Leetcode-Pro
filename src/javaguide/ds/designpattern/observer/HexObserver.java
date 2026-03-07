package javaguide.ds.designpattern.observer;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName HexObserver
 * @since 2023/4/24 17:43
 */
public class HexObserver extends Observer {

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    protected void update() {
        System.out.println("Hex string [" + Integer.toHexString(this.subject.getState()) + "].");
    }
}
