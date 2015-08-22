package org.teng.practice.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author baichuan
 * @date 8/23/15.
 */
public class Waiter {
    private List<Command> commands = new ArrayList<>();

    public void setOrder(Command command) {
        if (command instanceof BakeMuttonCommand) {
            System.out.println("增加订单：来份烤羊肉串");
        } else if (command instanceof BakeChickenWingCommand) {
            System.out.println("增加订单：来份烤鸡翅");
        } else {
            System.out.println("客官，抱歉，小店真没有");
            return;
        }
        commands.add(command);
    }

    public void cancelOrder(Command command) {
        if (commands.contains(command)) {
            if (command instanceof BakeMuttonCommand) {
                System.out.println("取消订单：取消烤羊肉串");
            } else if (command instanceof BakeChickenWingCommand) {
                System.out.println("取消订单：取消烤羊肉串");
            } else {
                System.out.println("客官，抱歉，你没下该订单");
                return;
            }
            commands.remove(command);
        }
    }

    public void notifyBarbecuer() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
