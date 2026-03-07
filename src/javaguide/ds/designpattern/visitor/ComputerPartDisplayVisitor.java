package javaguide.ds.designpattern.visitor;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName ComputerPartDisplayVisitor
 * @since 2023/4/25 0:19
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Computer computer) {
        System.out.println("Display computer: " + computer);
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Display mouse: " + mouse);
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Display keyboard: " + keyboard);
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Display monitor: " + monitor);
    }
}
