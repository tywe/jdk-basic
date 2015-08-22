package org.teng.practice.pattern.command;

/**
 * description:
 *
 * @author baichuan
 * @date 8/23/15.
 */
public class BakeChickenWingCommand extends Command {
    public BakeChickenWingCommand(Barbecuer receiever) {
        super(receiever);
    }

    @Override
    public void execute() {
        receiever.bakeChickenWing();
    }
}
