package javaguide.ds.designpattern.visitor;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Monitor
 * @since 2023/4/25 0:17
 */
public class Monitor implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}
