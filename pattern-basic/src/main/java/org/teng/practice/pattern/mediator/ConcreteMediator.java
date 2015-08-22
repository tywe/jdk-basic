package org.teng.practice.pattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class ConcreteMediator extends Mediator {
    private List<Colleague> colleagueList = new ArrayList<>();

    public ConcreteMediator() {
    }

    @Override
    public void send(String message, Colleague colleague) {
        for (Colleague tmp : colleagueList) {
            if (colleague.equals(tmp)) {
                continue;
            }

            tmp.recieve(message);
        }
    }

    @Override
    public void addColleague(Colleague colleague) {
        colleagueList.add(colleague);
    }
}
