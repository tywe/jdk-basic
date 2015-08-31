package org.teng.spring.ioc;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/31
 */
public class Exams {
    private Student student;
    private Course course;

    public Exams(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public void exam() {
        System.out.println(this.student.getName() + "正在参加" + this.course.getName() + "考试...");
    }
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
}
