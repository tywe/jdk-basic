package org.teng.jdk.simple.string;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/17
 */
public class StringUtilsTest {
    private Logger logger = Logger.getLogger(getClass());
    private String obj = null;


    @Before
    public void setUp(){
        obj = "test string";
    }

    @Test
    public void isEmptyTest(){
        logger.debug("isEmpty:" + StringUtils.isEmpty(obj));
    }

    @After
    public void tearDown(){

    }
}
