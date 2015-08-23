package org.teng.practice.pattern.flyweight;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * description:享元模式
 * <p/>
 * 定义：运用共享技术有效支持大量细粒度的对象。
 * <p/>
 * 享元工厂：用来创建flyweight对象。它主要用来确保合理的共享flyweight，当用户请求一个flyweight
 * 时，flyweightFactory提供已建或创建一个flyweight实例。
 * <p/>
 * flyweight：所有具体享元类的超类或接口，通过这个接口，flyweight可以接受并作用与外部状态。
 * <p/>
 * concreteFlyweight:继承flyweight超类或实现flyweight接口，并为内部状态增加存储空间。
 * <p/>
 * unshardFlyweight：不需要共享的flyweight子类，不强制共享。
 * <p/>
 * 适用：如果一个应用程序使用了大量的对象，大量的对象会造成很大的内存开销；
 * 如果对象的大多数状态为外部状态，那么可以将外部状态放到客户端，那么可以使用相对较少的共享对象
 * 取代很多组对象。
 * <p/>
 * 缺点：享元模式需要委会一个记录了系统已有的所有享元列表，需要消耗资源；享元模式使得系统更复杂；
 * 为了使对象可以共享，需要把一些状态外部化，程序逻辑变复杂了。
 *
 * @author baichuan
 * @date 8/23/15.
 */
public class FlyweightTest {
    private int extrinsicState;
    private FlyweightFactory flyweightFactory;

    @Before
    public void setUp() throws Exception {
        extrinsicState = 22;
        flyweightFactory = new FlyweightFactory();
    }

    @Test
    public void testFlyweight() {
        Flyweight fx = flyweightFactory.getFlyweight("X");
        fx.operation(--extrinsicState);

        Flyweight fy = flyweightFactory.getFlyweight("X");
        fy.operation(--extrinsicState);

        Flyweight fz = flyweightFactory.getFlyweight("X");
        fz.operation(--extrinsicState);

        Flyweight uf = new UnshardConcreteFlyweight();
        uf.operation(--extrinsicState);
    }

    @After
    public void tearDown() throws Exception {
        flyweightFactory = null;
    }
}