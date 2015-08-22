package org.teng.practice.pattern.bridge.hard;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class RefineAbstraction extends Abstraction {
    @Override
    public void operation() {
        implementor.operation();
    }
}
