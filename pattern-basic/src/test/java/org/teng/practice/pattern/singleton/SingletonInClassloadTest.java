package org.teng.practice.pattern.singleton;

import org.junit.Test;

/**
 * description:单例模式：饿汉实现方式（在类加载时完成）
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class SingletonInClassloadTest {

    @Test
    public void testGetInstance() throws Exception {
        SingletonInClassload.getInstance();
    }
}