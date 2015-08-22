package org.teng.practice.pattern.Observer;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class ConcreteObserver extends Observer {
    private String name;
    private Subject subject;

    public ConcreteObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void update() {
        String message = String.format("观察者%s收到新消息：%s", name, subject.getSubjectState());
        System.out.println(message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
