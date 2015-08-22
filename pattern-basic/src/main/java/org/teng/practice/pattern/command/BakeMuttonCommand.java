package org.teng.practice.pattern.command;

/**
 * description:
 *
 * @author baichuan
 * @date 8/23/15.
 */
public class BakeMuttonCommand extends Command {
    public BakeMuttonCommand(Barbecuer receiever) {
        super(receiever);
    }

    @Override
    public void execute() {
        receiever.bakeMutton();
    }
}
