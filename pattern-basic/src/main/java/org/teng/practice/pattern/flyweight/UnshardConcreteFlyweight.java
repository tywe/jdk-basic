package org.teng.practice.pattern.flyweight;

/**
 * description:
 *
 * @author baichuan
 * @date 8/23/15.
 */
public class UnshardConcreteFlyweight extends Flyweight {
    @Override
    public void operation(int extrinsicState) {
        System.out.println("不共享的具体Flyweight:" + extrinsicState);
    }
}
