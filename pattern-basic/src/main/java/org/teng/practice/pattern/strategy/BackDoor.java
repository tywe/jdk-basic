package org.teng.practice.pattern.strategy;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class BackDoor implements Istrategy {

    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施压");
    }
}
