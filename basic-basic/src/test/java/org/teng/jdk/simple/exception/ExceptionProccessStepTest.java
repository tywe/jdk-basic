package org.teng.jdk.simple.exception;

import org.junit.Test;
import org.teng.jdk.problems.exception.ExceptionProccessStep;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/24
 */
public class ExceptionProccessStepTest {

    //    @Test
    public void testCatExp() throws Exception {
        ExceptionProccessStep.catExp();
    }

    //    @Test
    public void testThrExp() throws Exception {
        String result = ExceptionProccessStep.thrExp();
        System.out.println("result:" + result);
    }


    @Test
    public void testThrExpOuter() throws Exception {
        String result = "aaa";
        result = ExceptionProccessStep.thrExpOuter();

        System.out.println("result:" + result);
    }

    @Test
    public void testThrExpOuter1() {
        String result = "aaa";
        try {
            result = ExceptionProccessStep.thrExpOuter();
        } catch (Exception e) {
            System.out.println("异常：" + e.getMessage());
        }

        System.out.println("result:" + result);
    }
}