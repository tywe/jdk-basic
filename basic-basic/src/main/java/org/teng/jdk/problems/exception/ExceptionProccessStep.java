package org.teng.jdk.problems.exception;

/**
 * description:异常处理机制.
 * <p/>
 * 个人总结：
 * 1.发生异常时，异常执行过程try->exception->catch->finally
 * 2.不发生异常时，异常执行过程try->finally
 * ！！important---tips
 * 无论在try-catch中抛出异常或返回，都会执行finally块
 * <p/>
 * 参考：
 * http://blog.csdn.net/hguisu/article/details/6155636
 *
 * @author:baichuan
 * @date:2015/8/24
 */
public class ExceptionProccessStep {
    public static void catExp() {
        int result = 100;
        try {
            result = 100 / 0;
        } catch (Exception e) {
            System.out.println("异常：" + e.getMessage());
        } finally {
            System.out.println("finally...");
        }

        System.out.println("method end");
    }

    public static String thrExp() {
        int result = 100;
        try {
            result = 100 / 0;
        } catch (Exception e) {
            throw e;
        } finally {
            System.out.println("finally...");
        }

        System.out.println("method end");
        return "result";
    }

    public static String thrExpOuter() throws Exception {
        int result = 100;
        result = 100 / 0;

        System.out.println("method end");
        return "result";
    }

}


class TestException {
    public TestException() {
    }

    boolean testEx() throws Exception {
        boolean ret = true;
        try {
            ret = testEx1();
        } catch (Exception e) {
            System.out.println("testEx, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx1() throws Exception {
        boolean ret = true;
        try {
            ret = testEx2();
            if (!ret) {
                return false;
            }
            System.out.println("testEx1, at the end of try");
            return ret;
        } catch (Exception e) {
            System.out.println("testEx1, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx1, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx2() throws Exception {
        boolean ret = true;
        try {
            int b = 12;
            int c;
            for (int i = 2; i >= -2; i--) {
                c = b / i;
                System.out.println("i=" + i);
            }
            return true;
        } catch (Exception e) {
            System.out.println("testEx2, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx2, finally; return value=" + ret);
            return ret;
        }
    }

    public static void main(String[] args) {
        TestException testException1 = new TestException();
        try {
            testException1.testEx();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}