package org.teng.practice.pattern.singleton;

/**
 * description:单例模式-饿汉实现方式（静态初始化）
 * 保证一个类只有一个实例，并提供一个访问他的全局访问点
 * 单例模式可以实现受控访问
 *
 * @author baichuan
 * @date 8/22/15.
 */
public final class SingletonInClassload {
    private static SingletonInClassload instance = new SingletonInClassload();

    private SingletonInClassload() {
    }

    public static SingletonInClassload getInstance() {
        return instance;
    }
}
