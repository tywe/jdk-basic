package org.teng.practice.pattern.bridge;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class HandSetBrandN extends HandSetBrand {
    @Override
    public void run() {
        System.out.println("手机N开始运行软件...");
        soft.run();
    }
}
