package org.teng.practice.pattern.command;

/**
 * description:
 *
 * @author baichuan
 * @date 8/23/15.
 */
public abstract class Command {
    protected Barbecuer receiever;

    public Command(Barbecuer receiever) {
        this.receiever = receiever;
    }

    public abstract void execute();
}
