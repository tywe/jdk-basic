package org.teng.practice.pattern.adapter;

/**
 * description:
 *
 * @author baichuan
 * @date 8/22/15.
 */
public class Adepter extends Target {
    private Adeptee adeptee;

    public Adepter(Adeptee adeptee) {
        this.adeptee = adeptee;
    }

    @Override
    public void request() {
        adeptee.specificRequest();
    }

    public Adeptee getAdeptee() {
        return adeptee;
    }

    public void setAdeptee(Adeptee adeptee) {
        this.adeptee = adeptee;
    }
}
