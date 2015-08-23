package org.teng.practice.pattern.flyweight;

/**
 * description:
 *
 * @author baichuan
 * @date 8/23/15.
 */
public class ConcreteFlyweight extends Flyweight {
    @Override
    public void operation(int extrinsicState) {
        System.out.println("具体Flyweight：" + extrinsicState);
    }
}
