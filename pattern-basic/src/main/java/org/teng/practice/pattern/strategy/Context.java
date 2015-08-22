package org.teng.practice.pattern.strategy;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class Context {
    private Istrategy strategy;

    public Context(Istrategy strategy) {
        this.strategy = strategy;
    }

    public void operate() {
        this.strategy.operate();
    }
}
