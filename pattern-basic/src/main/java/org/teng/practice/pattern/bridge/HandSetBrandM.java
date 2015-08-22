package org.teng.practice.pattern.bridge;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class HandSetBrandM extends HandSetBrand {
    @Override
    public void run() {
        System.out.println("手机M开始运行软件...");
        soft.run();
    }
}
