package javaguide.ds.designpattern.state;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName StartState
 * @since 2023/4/24 19:17
 */
public class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state.");
        context.setState(this);
    }

    public String toString() {
        return "Start state";
    }
}
