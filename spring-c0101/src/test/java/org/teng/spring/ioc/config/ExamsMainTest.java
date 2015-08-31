package org.teng.spring.ioc.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.teng.spring.ioc.Exams;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/31
 */
public class ExamsMainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("org/teng/spring/ioc/exams.xml");
        Exams exams = (Exams) context.getBean("exams");
        exams.exam();
        context.close();
    }
}
