package javaguide.ds.designpattern.state;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Context
 * @since 2023/4/24 19:18
 */
public class Context {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
