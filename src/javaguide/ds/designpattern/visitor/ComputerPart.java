package javaguide.ds.designpattern.visitor;

/**
 * 电脑组件接口
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName ComputerPart
 * @since 2023/4/25 0:15
 */
public interface ComputerPart {

    void accept(ComputerPartVisitor visitor);

}
