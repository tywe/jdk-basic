package org.teng.practice.pattern.command.hard;

/**
 * description:
 *
 * @author baichuan
 * @date 8/23/15.
 */
public abstract class Command {
    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();
}
