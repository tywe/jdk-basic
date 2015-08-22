package org.teng.practice.pattern.proxy;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class Pursuit implements IGivingGift {
    private SchoolGirl schoolGirl;

    public Pursuit(SchoolGirl schoolGirl) {
        this.schoolGirl = schoolGirl;
    }

    @Override
    public void giveDoalls() {
        System.out.println(schoolGirl.getName() + "，送你布娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println(schoolGirl.getName() + "，送你鲜花");
    }

    @Override
    public void giveChocolate() {
        System.out.println(schoolGirl.getName() + "，送你巧克力");
    }
}
