package javaguide.ds.designpattern.interpreter;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName AndExpression
 * @since 2023/4/24 14:07
 */
public class AndExpression implements Expression {

    private Expression exp1, exp2;


    public AndExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public boolean interpret(String content) {
        return exp1.interpret(content) & exp2.interpret(content);
    }
}
