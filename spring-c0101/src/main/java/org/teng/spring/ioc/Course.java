package org.teng.spring.ioc;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/31
 */
public class Course {
    private String name;
    private int total;

    public Course(String name, int total) {
        this.name = name;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
