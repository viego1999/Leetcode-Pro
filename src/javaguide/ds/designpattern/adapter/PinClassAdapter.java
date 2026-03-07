package javaguide.ds.designpattern.adapter;

/**
 * 类适配器
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName PinAdapter
 * @since 2023/4/23 11:59
 */
public class PinClassAdapter extends TriplePin implements DualPin {
    @Override
    public void electrify(int l, int n) {
        System.out.println("Using class adapter, the [TriplePin] adapts to [DualPin].");
        super.electrify(l, n, -1);
    }
}
