package org.teng.practice.pattern.proxy;

import org.junit.Test;

/**
 * description:代理模式
 * 个人总结：通过间接访问被代理对象，在代理中增加其他业务逻辑，
 * 实现对被代理对象的管理（权限管理），最终执行者是被代理对象。
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class PusuitProxyTest {
    private SchoolGirl xiaohua = new SchoolGirl();
    private Pursuit baichuan = new Pursuit(xiaohua);
    private PusuitProxy proxy = new PusuitProxy(baichuan);

    @Test
    public void pursuitGirl() {
        proxy.giveDoalls();
        proxy.giveFlowers();
        proxy.giveChocolate();
    }
}