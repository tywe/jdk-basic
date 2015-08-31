package org.teng.spring.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.teng.spring.ioc.Course;
import org.teng.spring.ioc.Exams;
import org.teng.spring.ioc.Student;
import org.teng.spring.ioc.Teacher;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/31
 */
@Configuration
public class ExamsConfig {
    @Bean
    public Teacher teacher() {
        return new Teacher("王老师");
    }

    @Bean
    public Student student() {
        return new Student("baichuan", 20);
    }

    @Bean
    public Course course() {
        return new Course("cs", 100);
    }

    @Bean()
    public Exams exams() {
        return new Exams(student(), course());
    }

}
