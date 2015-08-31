package org.teng.spring.ioc.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExamsConfig.class, loader = AnnotationConfigContextLoader.class)
public class ExamsJavaConfigTest {
    @Autowired
    private Student student;

    @Autowired
    private Course course;

    @Autowired
    private Teacher teacher;

    @Autowired
    private Exams exams;

    @Test
    public void testExams() throws Exception {
        exams.exam();
    }
}