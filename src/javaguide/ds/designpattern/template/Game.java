package javaguide.ds.designpattern.template;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Game
 * @since 2023/4/25 0:03
 */
public abstract class Game {

    abstract void initialize();

    abstract void start();

    abstract void end();

    public final void play() {
        initialize();

        start();

        end();
    }

}
