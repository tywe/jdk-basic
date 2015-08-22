package org.teng.practice.pattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public abstract class Subject {
    private List<Observer> observerList = new ArrayList<>();

    public void attch(Observer observer) {
        observerList.add(observer);
    }

    public void detach(Observer observer) {
        if (observerList.contains(observer)) {
            observerList.remove(observer);
        }
    }

    public void notifyObservers() {
        if (observerList.size() > 0) {
            for (Observer observer : observerList) {
                observer.update();
            }
        }
    }

    public abstract String getSubjectState();

    public abstract void setSubjectState(String subjectState);
}
