package javaguide.ds.designpattern.observer;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OctalObserver
 * @since 2023/4/24 17:41
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    protected void update() {
        System.out.println("Octal string [" + Integer.toOctalString(this.subject.getState()) + "].");
    }
}
