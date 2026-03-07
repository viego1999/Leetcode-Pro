package javaguide.ds.designpattern.adapter;

/**
 * 对象适配器模式
 * <pre>
 *    意图：将一个类的接口转换成客户希望的另外一个接口。Adapter 模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 *    适用性：
 *       你想使用一个已经存在的类，而它的接口不符合你的需求。
 *       你想创建一个可以复用的类，该类可以与其他不相关的类或不可预见的类（即那些接口可能不一定兼容的类）协同工作。
 *       （仅适用于对象Adapter ）你想使用一些已经存在的子类，但是不可能对每一个都进行子类化以匹配它们的接口。对象适配器可以适配它的父类接口。
 * </pre>
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName TV
 * @since 2023/4/23 11:25
 */
public class AdapterDemo {
    public static void main(String[] args) {
        // 对象适配器使用
        PinObjectAdapter pinObjectAdapter = new PinObjectAdapter(new TriplePin());
        pinObjectAdapter.electrify(1, 1); // 两项插孔通电

        // 类适配器使用
        PinClassAdapter pinClassAdapter = new PinClassAdapter();
        pinClassAdapter.electrify(1, 1); // 两项插孔通电
    }
}
