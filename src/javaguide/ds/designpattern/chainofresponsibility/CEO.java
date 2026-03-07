package javaguide.ds.designpattern.chainofresponsibility;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName CEO
 * @since 2023/4/24 13:08
 */
public class CEO extends Approver {
    public CEO(String name) {
        super(name);
    }

    @Override
    public void approve(int amount) {
        if (amount <= 10000) {
            System.out.println("审批通过。CEO：" + name);
        } else {
            System.out.println("驳回申请。CEO：" + name);
        }
    }
}
