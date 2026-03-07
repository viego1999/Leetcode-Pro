package javaguide.ds.designpattern.interpreter;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName TerminalExpression
 * @since 2023/4/24 14:02
 */
public class TerminalExpression implements Expression {

    private String data;


    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String content) {
        return content.equals(data);
    }
}
