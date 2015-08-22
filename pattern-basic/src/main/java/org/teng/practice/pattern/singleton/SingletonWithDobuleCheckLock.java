package org.teng.practice.pattern.singleton;

/**
 * description:单例模式-懒汉实现方式（第一次调用）
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class SingletonWithDobuleCheckLock {
    private static SingletonWithDobuleCheckLock instance;
    private static final Object lock = new Object();

    private SingletonWithDobuleCheckLock() {

    }

    public static SingletonWithDobuleCheckLock getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new SingletonWithDobuleCheckLock();
                }
            }
        }

        return instance;
    }
}
