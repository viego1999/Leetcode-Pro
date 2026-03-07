package javaguide.ds.designpattern.state;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName StopState
 * @since 2023/4/24 19:19
 */
public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state.");
        context.setState(this);
    }

    public String toString() {
        return "Stop state";
    }
}
