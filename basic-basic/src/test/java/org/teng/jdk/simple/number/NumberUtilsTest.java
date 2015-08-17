package org.teng.jdk.simple.number;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.nio.DoubleBuffer;
import java.text.NumberFormat;

/**
 * description:测试从spring-core中提取出来的NumberUtils类.
 *
 * @author:baichuan
 * @date:2015/8/17
 */
public class NumberUtilsTest {
    private Long number = null;
    private Logger logger = Logger.getLogger(NumberUtilsTest.class);

    @Before
    public void setUp(){
        number = 10L;
    }


    @Test
    public void parseNumberTest(){
        Byte targetNum = NumberUtils.parseNumber("1000", Byte.class);
        logger.debug("targetNum:" + targetNum);
    }

    @Test
    public void convertNumberToTargetClassTest(){
        Double doubleNum = NumberUtils.convertNumberToTargetClass(number, Double.class);
        logger.debug("doubleNum:" + doubleNum);
    }

    @Test
    public void parseNumberByFormatorTest(){
        Double targetNum = NumberUtils.parseNumber("1000", Double.class, NumberFormat.getInstance());
        logger.debug("targetNum:" + targetNum);
    }

    @After
    public void tearDown(){
        number = null;
    }
}
