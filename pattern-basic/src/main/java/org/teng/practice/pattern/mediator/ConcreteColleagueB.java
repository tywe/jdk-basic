package org.teng.practice.pattern.mediator;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class ConcreteColleagueB extends Colleague {
    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        String sendMessage = this.getClass().getName() + " send message " + message;
        System.out.println(sendMessage);
        mediator.send(message, this);
    }

    @Override
    public void recieve(String message) {
        System.out.println(this.getClass().getName() + " recieve message : " + message);
    }
}
