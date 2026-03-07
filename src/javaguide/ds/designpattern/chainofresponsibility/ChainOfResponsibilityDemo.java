package javaguide.ds.designpattern.chainofresponsibility;

/**
 * 责任链模式
 * <pre>
 *    意图：使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。
 *
 *    适用性：
 *       有多个的对象可以处理一个请求，哪个对象处理该请求运行时刻自动确定。
 *       你想在不明确指定接收者的情况下，向多个对象中的一个提交一个请求。
 *       可处理一个请求的对象集合应被动态指定。
 * </pre>
 * @author Wuxy
 * @version 1.0
 * @ClassName ChainOfResponsibilityDemo
 * @since 2023/4/24 13:09
 */
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        Approver flightJohn = new Staff("张飞");
        flightJohn.setNextApporver(new Manager("关羽")).setNextApporver(new CEO("刘备"));

        flightJohn.approve(1000);
        System.out.println("----------------------");

        flightJohn.approve(4000);
        System.out.println("----------------------");

        flightJohn.approve(9000);
        System.out.println("----------------------");

        flightJohn.approve(88000);
    }
}
