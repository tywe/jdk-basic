package org.teng.practice.pattern.bridge.hard;

import org.junit.Test;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class BridgeTest {
    Abstraction abstraction = new RefineAbstraction();
    Implementor implementorA = new ConcreteImplementorA();
    Implementor implementorB = new ConcreteImplementorB();

    @Test
    public void testBridge() {
        abstraction.setImplementor(implementorA);
        abstraction.operation();

        abstraction.setImplementor(implementorB);
        abstraction.operation();
    }
}