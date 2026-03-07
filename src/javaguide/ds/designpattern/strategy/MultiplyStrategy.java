package javaguide.ds.designpattern.strategy;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName MultiplyStrategy
 * @since 2023/4/24 22:45
 */
public class MultiplyStrategy implements Strategy {
    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}
