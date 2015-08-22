package org.teng.practice.pattern.proxy;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class PusuitProxy implements IGivingGift {
    private Pursuit pursuit;

    public PusuitProxy(Pursuit pursuit) {
        this.pursuit = pursuit;
    }

    @Override
    public void giveDoalls() {
        this.pursuit.giveDoalls();
    }

    @Override
    public void giveFlowers() {
        this.pursuit.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        this.pursuit.giveChocolate();
    }
}
