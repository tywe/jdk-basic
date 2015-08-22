package org.teng.practice.pattern.mediator;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public abstract class Mediator {
    public Mediator() {
    }

    public abstract void send(String message, Colleague colleague);

    public abstract void addColleague(Colleague colleague);
}
