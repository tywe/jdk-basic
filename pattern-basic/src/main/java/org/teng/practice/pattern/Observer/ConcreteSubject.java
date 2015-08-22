package org.teng.practice.pattern.Observer;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class ConcreteSubject extends Subject {
    private String subjectState;

    public ConcreteSubject(String subjectState) {
        this.subjectState = subjectState;
    }

    @Override
    public String getSubjectState() {
        return subjectState;
    }

    @Override
    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
