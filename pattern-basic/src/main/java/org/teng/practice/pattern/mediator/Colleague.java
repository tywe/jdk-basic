package org.teng.practice.pattern.mediator;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void send(String message);

    public abstract void recieve(String message);
}
