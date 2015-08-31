package org.teng.spring.ioc;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/31
 */
public class Teacher {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public void distributePapers() {
        System.out.println(this.name + "发试题，考试开始...");
    }

    public void collectPapers() {
        System.out.println(this.name + "收试题，考试结束...");
    }

}
