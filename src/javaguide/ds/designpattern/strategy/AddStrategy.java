package javaguide.ds.designpattern.strategy;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName AddStrategy
 * @since 2023/4/24 22:41
 */
public class AddStrategy implements Strategy {
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
