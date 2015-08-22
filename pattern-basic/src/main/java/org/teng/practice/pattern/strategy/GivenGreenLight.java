package org.teng.practice.pattern.strategy;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class GivenGreenLight implements Istrategy {
    @Override
    public void operate() {
        System.out.println("求吴国太开个绿灯，放行");
    }
}
