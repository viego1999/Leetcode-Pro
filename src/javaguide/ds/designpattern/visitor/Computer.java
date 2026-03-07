package javaguide.ds.designpattern.visitor;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Computer
 * @since 2023/4/25 0:16
 */
public class Computer implements ComputerPart {

    ComputerPart[] parts = {new Mouse(), new Keyboard(), new Monitor()};

    @Override
    public void accept(ComputerPartVisitor visitor) {
        for (ComputerPart part : parts) {
            part.accept(visitor);
        }
        visitor.visit(this);
    }
}
