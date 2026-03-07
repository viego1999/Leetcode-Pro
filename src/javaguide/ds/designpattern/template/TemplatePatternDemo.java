package javaguide.ds.designpattern.template;

/**
 * 模板模式
 * <pre>
 *    意图：定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。TemplateMethod 使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 *    适用性：
 *      - 一次性实现一个算法的不变的部分，并将可变的行为留给子类来实现。
 *      - 各子类中公共的行为应被提取出来并集中到一个公共父类中以避免代码重复。这是Opdyke 和Johnson 所描述过的“重分解以一般化”的一个很好的例子[ OJ93 ]。首先识别现有代码中的不同之处，并且将不同之处分离为新的操作。最后，用一个调用这些新的操作的模板方法来替换这些不同的代码。
 *      - 控制子类扩展。模板方法只在特定点调用“hook ”操作（参见效果一节），这样就只允许在这些点进行扩展。
 * </pre>
 * @author Wuxy
 * @version 1.0
 * @ClassName TemplatePatternDemo
 * @since 2023/4/25 0:09
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();

        game = new Football();
        game.play();
    }
}
