package javaguide.ds.designpattern.strategy;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Context
 * @since 2023/4/24 22:46
 */
public class Calculator {
    private Strategy strategy;


    public Calculator(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calculate(int num1, int num2) {
        return this.strategy.calculate(num1, num2);
    }
}
