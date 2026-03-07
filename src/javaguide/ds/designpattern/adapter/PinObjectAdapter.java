package javaguide.ds.designpattern.adapter;

/**
 * 适配器，将三孔插座适配成两孔插座，对象适配器模式
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName Adapter
 * @since 2023/4/23 11:27
 */
public class PinObjectAdapter implements DualPin {

    TriplePin triplePin;

    public PinObjectAdapter(TriplePin triplePin) {
        this.triplePin = triplePin;
    }

    @Override
    public void electrify(int l, int n) {
        System.out.println("Using object adapter, the [TriplePin] adapts to [DualPin].");
        triplePin.electrify(l, n, -1);
    }
}
