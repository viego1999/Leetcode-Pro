package javaguide.ds.designpattern.visitor;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Mouse
 * @since 2023/4/25 0:16
 */
public class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}
