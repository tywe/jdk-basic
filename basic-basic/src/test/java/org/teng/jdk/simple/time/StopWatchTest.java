package org.teng.jdk.simple.time;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/19
 */
public class StopWatchTest {
    private Logger logger = Logger.getLogger(getClass());
    private List<Thread> threadList = new ArrayList<>();
    private final Integer THREAD_SIZE = 3;

    @Before
    public void setUp() {
        for (int i = 0; i < THREAD_SIZE; i++){
            threadList.add(new Thread(new Runnable() {

                @Override
                public void run() {

                    logger.debug(this.toString() + " begin to run");
                    try {
//                        Thread.sleep(Math.round(1000 * Math.random()));
                        logger.debug(this.toString() + " is runing");
//                        throw new Exception("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    logger.debug(this.toString() + " stopped");
                }
            }, "thread_" + i));
        }
    }

    @Test
    public void runTimeTest(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for(int i = 0; i < THREAD_SIZE; i ++){
            threadList.get(i).run();
        }
        stopWatch.stop();
        logger.debug(stopWatch.prettyPrint());
    }

    @After
    public void tearDown(){
        threadList.clear();
        logger.debug("threadList:" + (threadList == null ? null : threadList.size()));
    }
}
