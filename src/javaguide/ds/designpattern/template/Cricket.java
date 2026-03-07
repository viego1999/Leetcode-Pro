package javaguide.ds.designpattern.template;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Cricket
 * @since 2023/4/25 0:08
 */
public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket game initialized! Start playing");
    }

    @Override
    void start() {
        System.out.println("Cricket game started. Enjoy the game!");
    }

    @Override
    void end() {
        System.out.println("Cricket game finished!");
    }
}
