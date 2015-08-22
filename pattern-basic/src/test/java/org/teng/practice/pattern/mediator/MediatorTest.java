package org.teng.practice.pattern.mediator;

import org.junit.Test;

/**
 * description:中介模式
 * 定义：用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式的相互引用，从而使其耦合松散，
 * 而且可以独立的改变他们之间的交互。
 * 优点：1.减少collague间的耦合，让每个colleague独立的变化；
 * 2.将对象中的协作进行抽象，将中介作为一个独立的概念封装在一个对象中，将关注各对象的行为，
 * 转移到它们在中介中交互。
 * 缺点：中介类非常复杂，不容易维护。
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class MediatorTest {
    private Mediator mediator = new ConcreteMediator();
    private Colleague concreteColleagueA = new ConcreteColleagueA(mediator);
    private Colleague concreteColleagueB = new ConcreteColleagueB(mediator);


    @Test
    public void TestMediator() {
        mediator.addColleague(concreteColleagueA);
        mediator.addColleague(concreteColleagueB);

        concreteColleagueA.send("大家好，我是A");
        concreteColleagueB.send("大家好，我是B");
    }
}