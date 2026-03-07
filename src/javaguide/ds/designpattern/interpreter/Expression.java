package javaguide.ds.designpattern.interpreter;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Expression
 * @since 2023/4/24 14:02
 */
@FunctionalInterface
public interface Expression {

    boolean interpret(String content);

}
