package org.teng.spring.ioc.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.teng.spring.ioc.Exams;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:org/teng/spring/ioc/exams.xml")
public class ExamsXmlConfigTest {
    @Autowired
    private Exams exams;

    @Test
    public void testExams() {
        exams.exam();
    }
}
