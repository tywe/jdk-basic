package org.teng.jdk.reflect;

import java.net.URL;

/**
 * Created by Administrator on 6/14/15.
 */
public class BootStrapTest {
    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();

        for(int i = 0; i < urls.length; i++){
            System.out.println(urls[i].toExternalForm());
        }
    }
}
