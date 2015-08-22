package org.teng.practice.pattern.adapter;

import org.junit.Test;

/**
 * description:适配器模式
 * 定义：将一个类的接口转换成客户希望的另外一个接口。Adepter模式使得原本由于接口不兼容而不能一起工作的
 * 哪些类可以一起工作。
 * <p/>
 * 适用场景：希望复用一些现存的类，但是由于接口又与复用环境要求不一致的情况。
 * <p/>
 * 事后控制不如事中控制，事中控制不如事前控制：
 * 如果事先能预防接口不同的问题，不匹配的问题就不会发生；
 * 在有小的接口不统一的问题发生时，及时重构，问题不至于扩大；
 * 只有碰到无法改变原有设计和代码的情况时，才考虑适配。
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class AdepterTest {
    private Adeptee adeptee = new Adeptee();
    private Target adepter = new Adepter(adeptee);

    @Test
    public void testAdepter() {
        adepter.request();
    }
}