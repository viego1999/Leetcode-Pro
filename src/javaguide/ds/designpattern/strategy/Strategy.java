package javaguide.ds.designpattern.strategy;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Strategy
 * @since 2023/4/24 22:38
 */
public interface Strategy {

    /**
     * calculate the num1 and num2
     *
     * @param num1 number 1
     * @param num2 number 2
     * @return the result
     */
    int calculate(int num1, int num2);

}
