package org.teng.jdk.simple.file;

import junit.framework.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/21
 */
public class ResourceUtilsTest {

    @Test
    public void testIsUrl() throws Exception {
        File destFile = new File("D:\\spring-mvc-copy.xml");
        URL url = ResourceUtils.getURL("D:\\spring-mvc.xml");
        if(ResourceUtils.isFileURL(url)){
            File file = ResourceUtils.getFile(url);
            Assert.assertEquals("spring-mvc.xml", file.getName());
            System.out.println("fileSize:" + file.length());
            FileSystemUtils.copyRecursively(file, destFile);
            FileSystemUtils.deleteRecursively(destFile);
        }
    }
}