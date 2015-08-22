package org.teng.practice.pattern.command;

import org.junit.Test;

/**
 * description:命令模式
 * 定义：将一个请求封装为一个对象，从而是你可以用不同的请求对客户进行参数化；
 * 对请求排队、记录请求日志以及可撤销操作。
 * <p/>
 * 实现行为请求这与行为实现者的解耦。
 *
 * @author baichuan
 * @date 8/23/15.
 */
public class CommandTest {
    private Barbecuer barbecuer = new Barbecuer();
    private Command bakeMutton1 = new BakeMuttonCommand(barbecuer);
    private Command bakeMutton2 = new BakeMuttonCommand(barbecuer);
    private Command bakeChickenWing1 = new BakeChickenWingCommand(barbecuer);
    private Command bakeChickenWing2 = new BakeChickenWingCommand(barbecuer);

    private Waiter waiter = new Waiter();

    @Test
    public void testCommand() {
        waiter.setOrder(bakeChickenWing1);
        waiter.setOrder(bakeChickenWing2);
        waiter.setOrder(bakeMutton1);
        waiter.setOrder(bakeMutton2);

        waiter.cancelOrder(bakeMutton2);

        waiter.notifyBarbecuer();
    }

}