package org.teng.practice.pattern.strategy;

import org.junit.Before;
import org.junit.Test;

/**
 * description:策略模式测试
 * 个人总结：策略模式适用于完成一件事有多种方法，通过提供通用的接口实现，
 * 屏蔽方法的差异性。在不同的场景和需求下可以灵活通过置换方法实现对象，
 * 达到预期的目的（数据结果）。
 * 优点：隐藏了算法实现，屏蔽了接口差异，更容易扩展，符合OCP原则。
 * 缺点：算法集比较大，导致类膨胀。例如，对双操作数算法通过策略模式实现，
 * 加减乘除、、、都要实现策略结口，并生成一个类。
 * 适用：算法过程非常复杂，同时算法数量基本可以枚举，例如机器学习总的经典
 * 分类算法。
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class ZhaoYunTest {
    private Context context;
    private Istrategy backDoor;
    private Istrategy blookEnemy;
    private Istrategy givenGreenLight;

    @Before
    public void setUp() {
        backDoor = new BackDoor();
        blookEnemy = new BlockEnemy();
        givenGreenLight = new GivenGreenLight();
    }

    @Test
    public void testBackDoor() {
        System.out.println("==============刚到吴国打开第一个==============");
        context = new Context(backDoor);
        context.operate();
    }

    @Test
    public void testBlockEnemy() {
        System.out.println("==============刚到吴国打开第二个==============");
        context = new Context(blookEnemy);
        context.operate();
    }

    @Test
    public void testGivenGreenLigth() {
        System.out.println("==============刚到吴国打开第三个==============");
        context = new Context(givenGreenLight);
        context.operate();
    }
}