package javaguide.ds.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Subject
 * @since 2023/4/24 17:18
 */
public class Subject {
    private int state;
    private final List<Observer> observers = new ArrayList<>();


    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    public void notifyAllObservers() {
        observers.forEach(Observer::update);
    }
}
