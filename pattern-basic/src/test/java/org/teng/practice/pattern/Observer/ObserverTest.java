package org.teng.practice.pattern.Observer;

import org.junit.Test;

/**
 * description:观察者模式
 * 观察者模式（发布/订阅模式）：定义了一种一对多的依赖关系，让多个观察者对象同时监控某个主题对象。
 * 主题对象状态发生变化时，它会通知所有观察者对象自动更新自己。
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class ObserverTest {
    private Subject boss = new ConcreteSubject("发工资");
    private Observer baichuan = new ConcreteObserver("baichuan", boss);
    private Observer xiaohua = new ConcreteObserver("xiaohua", boss);

    @Test
    public void testObserver() {
        boss.attch(baichuan);
        boss.attch(xiaohua);

        System.out.println("手机响起...");
        boss.notifyObservers();

        System.out.println("手机响起...");
        boss.setSubjectState("发奖金");
        boss.notifyObservers();
    }
}