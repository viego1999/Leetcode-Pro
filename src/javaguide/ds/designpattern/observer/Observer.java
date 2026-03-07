package javaguide.ds.designpattern.observer;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Observer
 * @since 2023/4/24 17:17
 */
public abstract class Observer {
    protected Subject subject;

    protected abstract void update();
}
