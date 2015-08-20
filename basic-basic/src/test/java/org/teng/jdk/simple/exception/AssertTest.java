package org.teng.jdk.simple.exception;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/18
 */
public class AssertTest {
    private Logger logger = Logger.getLogger(getClass());

    private boolean status = false;

    @Before
    public void setUp(){

    }

    /**
     * 测试：抽象类可以直接使用它的静态方法!!!
     */
    @Test
    public void isTrueTest(){
        try {
            Assert.isTrue(status, "status:" + status);
        } catch (Exception e) {
//            e.printStackTrace();
            logger.debug("error:" + e.getMessage());
        }
    }

    @After
    public void tearDown(){

    }


}
