package org.teng.practice.pattern.bridge.hard;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class ConcreteImplementorA extends Implementor {
    @Override
    public void operation() {
        System.out.println("具体实现A的方法执行");
    }
}
