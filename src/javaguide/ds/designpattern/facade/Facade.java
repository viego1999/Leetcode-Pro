package javaguide.ds.designpattern.facade;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Facade
 * @since 2023/4/23 13:35
 */
public class Facade {
    VegVendor vegVendor;
    Waiter waiter;
    Chef chef;
    Cleaner cleaner;


    public Facade() {
        this.vegVendor = new VegVendor();
        // 开门前就找菜贩子准备好蔬菜
        vegVendor.sell();
        // 雇佣好饭店的服务人员
        waiter = new Waiter();
        chef = new Chef();
        cleaner = new Cleaner();
    }

    public void provideService() {
        waiter.order();
        chef.cook();
        waiter.serve();
        cleaner.clean();
        cleaner.wash();
    }
}
