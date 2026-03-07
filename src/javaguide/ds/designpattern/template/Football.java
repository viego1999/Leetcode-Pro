package javaguide.ds.designpattern.template;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Football
 * @since 2023/4/25 0:06
 */
public class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football game initialized! Start playing");
    }

    @Override
    void start() {
        System.out.println("Football game started. Enjoy the game!");
    }

    @Override
    void end() {
        System.out.println("Football game finished!");
    }
}
