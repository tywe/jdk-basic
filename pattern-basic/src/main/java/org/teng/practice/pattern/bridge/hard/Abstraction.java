package org.teng.practice.pattern.bridge.hard;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public abstract class Abstraction {
    protected Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation();
}
