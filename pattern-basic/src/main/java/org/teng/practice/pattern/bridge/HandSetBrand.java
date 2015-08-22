package org.teng.practice.pattern.bridge;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public abstract class HandSetBrand {
    protected HandsetSoft soft;

    public void SetHandsetSoft(HandsetSoft soft) {
        this.soft = soft;
    }

    public abstract void run();
}

