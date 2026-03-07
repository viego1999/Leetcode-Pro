package javaguide.ds.designpattern.visitor;

/**
 * 电脑组件访问者接口
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName ComputerPartVisitor
 * @since 2023/4/25 0:15
 */
public interface ComputerPartVisitor {

    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);

}
