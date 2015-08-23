package org.teng.practice.pattern.responsibility;

import org.junit.Before;
import org.junit.Test;

/**
 * description:职责链模式
 * 个人总结：明确职责（高内聚），链式处理（不明确谁能处理）
 * 设置后继，明确每个处理器职责范围。
 * <p/>
 * 定义：使多个对象都有机会处理请求，从而避免避免请求的发送者和接受这间的耦合关系。将这些对象连成一条链，
 * 并沿着这条链传递该请求，知道有一个对象处理它为止。
 * <p/>
 * 优点：
 * 简化客户提交请求，请求沿着链传递，直到有一个处理对象能够处理它；
 * 处理器不需直到整个链的存在及构成，只需保存后继的引用，降低对象间的耦合性；
 * 处理器可以灵活的增加、删除、修改。
 * <p/>
 * 缺点：
 * 思考不全面，可能导致请求到链的末端都得不到处理；
 * 职责链配置错误导致请求得不到处理；
 * 当处理链比较长时，会带来性能问题（链不太长，10个以内；处理过程比较复杂，使用不明确（细分职责））。
 *
 * @author baichuan
 * @date 8/23/15.
 */
public class HandlerTest {
    private Handler handlerA = new ConcreteHandlerA(null);
    private Handler handlerB = new ConcreteHandlerB(handlerA);
    private Handler handlerC = new ConcreteHandlerC(handlerB);


    int request = 10;

    @Before
    public void setUp() {
        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);
    }

    @Test
    public void testHandler() {
        handlerC.handlerRequest(request);
    }

}