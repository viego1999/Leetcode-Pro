package javaguide.ds.designpattern.chainofresponsibility;

/**
 * 审批人抽象类
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName Approver
 * @since 2023/4/24 12:47
 */
public abstract class Approver {
    protected String name; // 抽象出审批人的姓名
    protected Approver nextApprover; // 下一个审批人，更高级别的领导


    public Approver(String name) {
        this.name = name;
    }

    protected Approver setNextApporver(Approver nextApprover) {
        this.nextApprover = nextApprover;
        return this.nextApprover; // 放回下一个审批人，链式编程
    }

    public abstract void approve(int amount); // 抽象方法，有具体子类实现
}
