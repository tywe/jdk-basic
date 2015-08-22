package org.teng.practice.pattern.command.hard;

/**
 * description:
 *
 * @author baichuan
 * @date 8/23/15.
 */
public class ConcreteCommand extends Command {
    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
