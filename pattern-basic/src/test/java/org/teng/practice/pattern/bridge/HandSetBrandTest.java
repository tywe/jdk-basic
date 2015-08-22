package org.teng.practice.pattern.bridge;

import org.junit.Test;

/**
 * description:桥接模式
 * 定义：桥接模式-将抽象部分和它的实现部分分类，使它们可以独立的变化。
 * 个人理解：当具体实现有多种变化维度是，在每个维度上分别抽象实现，通过和聚合而不是组合的方式分离
 * 不同维度的变化二导致的具体实现的扩展。
 * <p/>
 * 案例：1.手机->品牌->软件  ==>    软件<-手机->品牌
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class HandSetBrandTest {
    private HandsetSoft game = new HandsetGame();
    private HandsetSoft address = new HandsetAddressList();

    private HandSetBrand brandM = new HandSetBrandM();
    private HandSetBrand brandN = new HandSetBrandN();

    @Test
    public void testBridge() {
        brandM.SetHandsetSoft(game);
        brandM.run();

        brandN.SetHandsetSoft(address);
        brandN.run();
    }
}