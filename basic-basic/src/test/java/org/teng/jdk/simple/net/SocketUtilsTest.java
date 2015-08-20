package org.teng.jdk.simple.net;

import junit.framework.TestCase;
import org.teng.jdk.simple.exception.Assert;

import java.util.SortedSet;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/19
 */
public class SocketUtilsTest extends TestCase {
    public void testFindAvailableTcpPorts() throws Exception {
        SortedSet<Integer> availablePorts = SocketUtils.findAvailableTcpPorts(10, 1000, 2550);
        junit.framework.Assert.assertEquals(availablePorts.size(), 10);
    }

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

}