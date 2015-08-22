package org.teng.practice.pattern.strategy;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class BlockEnemy implements Istrategy {
    @Override
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}
