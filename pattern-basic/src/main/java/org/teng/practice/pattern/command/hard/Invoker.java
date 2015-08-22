package org.teng.practice.pattern.command.hard;

/**
 * description:
 *
 * @author baichuan
 * @date 8/23/15.
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }
}
